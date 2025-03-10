package com.arqueobd.arqueobdrf.service;

import com.arqueobd.arqueobdrf.entity.Site;
import com.arqueobd.arqueobdrf.error.SiteNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//permite definir los métodos a implementar en la caja de servicios
public interface SiteService {
    List<Site> findAllSites() throws SiteNotFoundException;
    Site saveSite(Site site);
    Site updateSite(Long id, Site site);
    void deleteSite(Long id) throws SiteNotFoundException;
    Optional<Site> findSiteByWithJPQL(String name) throws SiteNotFoundException;
    Optional<Site> findByName(String name) throws SiteNotFoundException;
    Optional<Site> findByNameIgnoreCase(String name) throws SiteNotFoundException;
    Site findSiteById(Long id) throws SiteNotFoundException;
}
