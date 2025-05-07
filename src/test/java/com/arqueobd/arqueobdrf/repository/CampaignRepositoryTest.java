package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Campaign;
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
                .startDate(startDateTest)
                .endDate(endDateTest)
                .description("Campaña en el castro x de 2021, prueba de testing unitario")
                .build();
        campaignRepository.save(campaign);
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

}