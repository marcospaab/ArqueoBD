package com.arqueobd.arqueobdrf.service;

import com.arqueobd.arqueobdrf.entity.Site;
import com.arqueobd.arqueobdrf.error.SiteNotFoundException;
import com.arqueobd.arqueobdrf.repository.SiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//tests unitarios de la capa de servicios
//no hay persistencia en la base de datos. Se simula en el siteRepository por ser mockbean
@Slf4j
@SpringBootTest
class SiteServiceTest {

    @Autowired
    private SiteService siteService;
    @MockitoBean
    private SiteRepository siteRepository;

    @BeforeEach
    void setUp() {
        Site site = Site.builder()
                .id(1L)
                .name("Castro de Baroña")
                .coordinates("ABC")
                .code("CDB")
                .build();

        //cuando siteRepository sea invocado recibiendo castro de baroña, devuelve el objeto del builder, simulando que
        //viene de la base de datos.
        Mockito.when(siteRepository.findByNameIgnoreCase("Castro de Baroña")).thenReturn(Optional.of(site));
    }

    //pasamos un nombre que creemos que está en la base de datos y vemos como se comporta
    @Test
    @DisplayName("Prueba de obtención de información de un yacimiento enviando nombre válido.")
    public void findByNameIgnoreCaseShouldFound() throws SiteNotFoundException {
        String siteName = "Castro de Baroña";
        Site site = siteService.findByNameIgnoreCase(siteName).get();
        assertEquals(siteName, site.getName());
        System.out.println("Site= "+site);
    }
}