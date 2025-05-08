package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Campaign;
import com.arqueobd.arqueobdrf.entity.Director;
import com.arqueobd.arqueobdrf.entity.Storehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//test unitario comprobando el registro de nuevas campañas (el codigo debe ser único)
@SpringBootTest
class CampaignRepositoryTest {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Date startDateTest = sdf.parse("10-05-2021");
    Date endDateTest = sdf.parse("20-06-2021");

    @Autowired //inyecta el repo
    CampaignRepository campaignRepository;

    CampaignRepositoryTest() throws ParseException {
    }

    @Test
    public void saveCampaign(){
        Campaign campaign = Campaign.builder()
                .campaignCode("SCQ2024")
                .startDate(startDateTest)
                .endDate(endDateTest)
                .description("Campaña en el castro x de 2021, prueba de testing unitario")
                .build();
        campaignRepository.save(campaign);
    }

    @Test
    public void saveMultipleCampaigns(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate1, endDate1, startDate2, endDate2, startDate3, endDate3;

        try {
            startDate1 = sdf.parse("15-07-2022");
            endDate1 = sdf.parse("30-08-2022");

            startDate2 = sdf.parse("01-06-2023");
            endDate2 = sdf.parse("20-07-2023");

            startDate3 = sdf.parse("05-05-2024");
            endDate3 = sdf.parse("10-06-2024");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Storehouse storehouse1 = Storehouse.builder()
                .storehouseMainStreet("Praza Maior, 2, 27001")
                .storehouseCity("Lugo")
                .storehouseCCAA("Galicia")
                .storehouseName("Museo Provincial de Lugo")
                .build();

        Storehouse storehouse2 = Storehouse.builder()
                .storehouseMainStreet("Avenida da Coruña, 25, 15003")
                .storehouseCity("A Coruña")
                .storehouseCCAA("Galicia")
                .storehouseName("Museo Arqueolóxico e Histórico da Coruña")
                .build();

        Storehouse storehouse3 = Storehouse.builder()
                .storehouseMainStreet("Rúa do Hórreo, 61, 15702")
                .storehouseCity("Santiago de Compostela")
                .storehouseCCAA("Galicia")
                .storehouseName("Museo do Pobo Galego")
                .build();

        Campaign campaign1 = Campaign.builder()
                .campaignCode("LUG2022")
                .startDate(startDate1)
                .endDate(endDate1)
                .description("Excavación en el Castro de Viladonga, campaña de verano 2022")
                .storehouse(storehouse1)
                .build();

        Campaign campaign2 = Campaign.builder()
                .campaignCode("COR2023")
                .startDate(startDate2)
                .endDate(endDate2)
                .description("Intervención arqueológica en Torre de Hércules")
                .storehouse(storehouse2)
                .build();

        Campaign campaign3 = Campaign.builder()
                .campaignCode("SCQ2024")
                .startDate(startDate3)
                .endDate(endDate3)
                .description("Excavación preventiva en la Praza do Obradoiro")
                .storehouse(storehouse3)
                .build();

        campaignRepository.save(campaign1);
        campaignRepository.save(campaign2);
        campaignRepository.save(campaign3);
    }

    @Test
    public void saveCampaignWithDirector(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate1, endDate1;

        try {
            startDate1 = sdf.parse("18-10-2023");
            endDate1 = sdf.parse("30-12-2023");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Storehouse storehouse = Storehouse.builder()
                .storehouseMainStreet("Baixada a Chousa, 61, 36998")
                .storehouseCity("Pontevedra")
                .storehouseCCAA("Galicia")
                .storehouseName("Museo Arqueológico de Pontevedra")
                .build();

        Director director = Director.builder()
                .firstName("Fermín")
                .lastName("Pérez Losada")
                .build();

        Campaign campaign = Campaign.builder()
                .campaignCode("TRE2023")
                .startDate(startDate1)
                .endDate(endDate1)
                .description("Excavación preventiva en la Praza do Obradoiro")
                .storehouse(storehouse)
                .director(director)
                .build();

        campaignRepository.save(campaign);
    }

    @Test
    public void findAllCampaignsWithDirector(){
        List<Campaign> campaignList = campaignRepository.findAll();
        System.out.println("campaignList = "+campaignList);
    }

    @Test
    public void saveCampaignWithStorehouseEmbedded(){
        Storehouse storehouse = Storehouse.builder()
                .storehouseMainStreet("Rúa a Granxa, 1D, 32005")
                .storehouseCity("Ourense")
                .storehouseCCAA("Galicia")
                .storehouseName("Museo Arqueolóxico Provincial de Ourense")
                .build();

        Campaign campaign = Campaign.builder()
                .campaignCode("SAC025")
                .startDate(startDateTest)
                .endDate(endDateTest)
                .description("Campaña en el castro x de 2021, prueba de testing unitario")
                .storehouse(storehouse)
                .build();
        campaignRepository.save(campaign);
    }

    //METODO PERSONALIZADO. JPA AUTOMATIZA EL MÉTODO SI EL NOMBRE CASA CON EL NOMBRE DE LA VARIABLE DE LA ENTIDAD
    @Test
    public void findCampaignByCode(){
        //se pone orElse con el null por que los campos retornan un Optional, no un objeto Campaign
        Campaign campaign = campaignRepository.findByCampaignCode("SA020").orElse(null);
        System.out.println("campaign = "+campaign);
    }

    //TEST UNITARIO PARA TRAER LISTA DE TODAS LAS CAMPAÑAS POR ID. METODO INTERNO JPA
    @Test
    public void findAllCampaigns(){
        List<Campaign> campaignList = campaignRepository.findAll();
        System.out.println("Campaigns = "+campaignList);
    }

    @Test
    public void findAllCampaignsByCodeContaining(){
        List<Campaign> campaignList = campaignRepository.findByCampaignCodeContaining("202");
        System.out.println("Campaign List = "+campaignList);
    }

    @Test
    public void findAllCampaignsStartDateNotNull(){
        List<Campaign> campaignList = campaignRepository.findByStartDateNotNull();
        System.out.println(campaignList);
    }

    //este test accede a las variables de la entidad embebida storehouse a través de campaign
    @Test
    public void findAllCampaignsByStorehouseName(){
        List<Campaign>campaignList = campaignRepository.findByStorehouse_StorehouseName("Museo do Pobo Galego");
        System.out.println("Depósitos en el Museo do Pobo Galego = " + campaignList);
    }

    @Test
    public void findAllCampaignsByStorehouseNameContaining(){
        List<Campaign>campaignList = campaignRepository.findByStorehouse_StorehouseNameContaining("Pobo");
        System.out.println("Depósitos en el Museo do Pobo Galego = " + campaignList);
    }

    @Test
    public void getCampaignByCampaignCode(){
        Campaign campaign = campaignRepository.getCampaignByCampaignCode("LUG2022");
        System.out.println(campaign);
    }

    @Test
    public void getCampaignDescriptionByCampaignCode(){
        String campaignDescription = campaignRepository.getCampaignDescriptionByCampaignCode("LUG2022");
        System.out.println(campaignDescription);
    }

    //test unitario consulta nativa
    @Test
    public void getCampaginByCampaignCodeNative(){
        Campaign campaign = campaignRepository.getCampaignByCampaignCodeNative("COR2023");
        System.out.println(campaign);
    }

    @Test
    public void getCampaginByCampaignCodeNativeNamedParam(){
        Campaign campaign = campaignRepository.getCampaignByCampaignCodeNativeParam("COR2023");
        System.out.println(campaign);
    }

    @Test
    public void updateCampaignDescriptionByCampaignCode(){
        campaignRepository.updateCampaignDescriptionByCampaignCode("Nova intervención arqueolóxica no Castro da Saceda. Limpeza superficial e preparación para o turismo.","SAC2021");
    }
}