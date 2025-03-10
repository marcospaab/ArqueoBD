package com.arqueobd.arqueobdrf.controller;


import com.arqueobd.arqueobdrf.entity.Site;
import com.arqueobd.arqueobdrf.error.SiteNotFoundException;
import com.arqueobd.arqueobdrf.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class SiteController {

    @Autowired
    SiteService siteService;

    //permite acceder a todos los yacimientos mediante esa ruta
    @GetMapping("/findAllSites")
    public List<Site> findAllSites() throws SiteNotFoundException {
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
    public String deleteSite(@PathVariable Long id) throws SiteNotFoundException{
        siteService.deleteSite(id);
        return "Registry successfully deleted";
    }

    //registro filtrado por id (se le pasa id y envia toda la info)
    @GetMapping("/findSiteById/{id}")
    Site findSiteById(@PathVariable Long id) throws SiteNotFoundException {
        return siteService.findSiteById(id);
    }

    //registro filtrado por nombre de yacimiento (se le pasa nombre y envia toda la info)
    @GetMapping("/findSiteByNameWithJPQL/{name}")
    Optional<Site> findSiteByNameWithJPQL(@PathVariable String name) throws SiteNotFoundException{
        return siteService.findSiteByWithJPQL(name);
    }

    //registro filtrado por nombre de yacimiento (se le pasa nombre y envia toda la info) pero por INVERSION DE CONTROL
    @GetMapping("/findSiteByName/{name}")
    Optional<Site> findByName(@PathVariable String name) throws SiteNotFoundException{
        return siteService.findByName(name);
    }

    //implementar metodo de busqueda ignorando cases
    @GetMapping("/findSiteByNameIgnoreCase/{name}")
    Optional<Site> findByNameIgnoreCase(@PathVariable String name) throws SiteNotFoundException{
        return siteService.findByNameIgnoreCase(name);
    }
}
