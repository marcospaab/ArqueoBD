package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Site;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//pruebas unitarias a la capa de repositorio
@DataJpaTest
class SiteRepositoryTest {

    @Autowired
    SiteRepository siteRepository;
    @Autowired
    TestEntityManager testEntityManager;

    //se ingresa este registro
    @BeforeEach
    void setUp() {
        Site site =
                Site.builder()
                        .name("San Cibrán de Las")
                        .coordinates("42.36036788885571, -8.03121627485587")
                        .code("SCL")
                        .build();
        testEntityManager.persist(site);
    }

    //escenario ideal donde la aplicación encuentra el registro en la base de datos
    //se ejecuta el registro anterior con el @test
    @Test
    public void findSiteByNameIgnoreCaseFound(){
        Optional<Site> site = siteRepository.findByNameIgnoreCase("San Cibrán de Las");
        //compara el registro pedido anterior
        assertEquals("San Cibrán de Las", site.get().getName());
        //log de comprobacion
        System.out.println("site.get() = "+site.get());
    }

    //escenario donde no encuentra el registro pedido de la base de datos
    @Test
    public void findLocalByIgnoreACaseNotFound(){
        Optional<Site> site = siteRepository.findByNameIgnoreCase("Castro de Baroña");
        //si no encuentra site devuelve un optional.empty
        assertEquals(site, Optional.empty());
    }

}