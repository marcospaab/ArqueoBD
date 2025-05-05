package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Campaign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//test unitario comprobando el registro de nuevas campañas (el codigo debe ser unico)
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

}