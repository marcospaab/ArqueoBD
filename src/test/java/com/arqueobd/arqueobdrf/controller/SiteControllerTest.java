package com.arqueobd.arqueobdrf.controller;

import com.arqueobd.arqueobdrf.entity.Site;
import com.arqueobd.arqueobdrf.service.SiteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//clase de test para el nivel de controller
@WebMvcTest(SiteController.class)
class SiteControllerTest {

    //permite usar endpoint al controlador
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SiteService siteService;

    private Site site;

    @BeforeEach
    void setUp() {
        site = Site.builder()
                .id(1L)
                .name("Castro de Baroña")
                .coordinates("1234,5678")
                .code("CDB")
                .build();

    }


    //simula un guardar el registro de un site
    @Test
    public void saveSite() throws Exception{
        Site postSite = Site.builder()
                //el id se genera automaticamente
                .name("Castro de Baroña")
                .coordinates("1234,5678")
                .code("CDB")
                .build();

        Mockito.when(siteService.saveSite(postSite)).thenReturn(site);

        //envia en el post el objeto json que contiene la info definida en el objeto indicando a mockito que hacer
        //cuando se usa postsite se trata de simular el guardado de registro de la aplicacion
        mockMvc.perform(post("/saveSite").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\":\"Castro de Baroña\",\n" +
                        "    \"coordinates\":\"1234,5678\",\n" +
                        "    \"code\":\"CDB\"\n" +
                        "}"))
                .andExpect(status().isOk());

        System.out.println("Site introducido = "+site);
    }

    //devuelve la información que yo espero que esté en la base de datos cuando se le pasa un id
    @Test
    public void findSiteById() throws Exception{
        Mockito.when(siteService.findSiteById(1L)).thenReturn(site);
        //hace que mockmvc hace una peticion con id 1 y espera que regrese un json
        //espera un statusok y finalmente espera una respuesta en json que su campo nombre sea igual que el registrado
        mockMvc.perform(get("/findSiteById/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(site.getName()));

    }
}