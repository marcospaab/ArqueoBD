package com.arqueobd.arqueobdrf.service;

import com.arqueobd.arqueobdrf.entity.Site;

import java.util.List;
import java.util.Optional;

//permite definir los métodos a implementar en la caja de servicios
public interface SiteService {
    List<Site> findAllSites();
    Site saveSite(Site site);
    Site updateSite(Long id, Site site);
    void deleteSite(Long id);
    Optional<Site> findSiteByWithJPQL(String name);
    Optional<Site> findByName(String name);
    Optional<Site> findByNameIgnoreCase(String name);
}
