package com.arqueobd.arqueobdrf.controller;


import com.arqueobd.arqueobdrf.entity.Site;
import com.arqueobd.arqueobdrf.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiteController {

    @Autowired
    SiteService siteService;

    //permite acceder a todos los yacimientos mediante esa ruta
    @GetMapping("/findAllSites")
    public List<Site> findAllSites(){
        return siteService.findAllSites();
    }

    //guardado de información
    @PostMapping("/saveSite")
    public Site saveSite(@RequestBody Site site){
        return siteService.saveSite(site);
    }

    //actualizado de registro
    @PutMapping("/updateSite/{id}")
    public Site updateSite(@PathVariable Long id, @RequestBody Site site){
        return siteService.updateSite(id, site);
    }

    //eliminación de registro
    @DeleteMapping("/deleteSite/{id}")
    public String deleteSite(@PathVariable Long id){
        siteService.deleteSite(id);
        return "Registry successfully deleted";
    }
}
