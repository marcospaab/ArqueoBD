package com.arqueobd.arqueobdrf.service;


import com.arqueobd.arqueobdrf.entity.Site;
import com.arqueobd.arqueobdrf.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

//capa de servicio y logica a desarrollar
@Service
public class SiteServiceImpl implements SiteService{

    //inyecta el repositorio desde spring
    @Autowired
    SiteRepository siteRepository;

    //recupera todos los datos de la tabla sites
    @Override
    public List<Site> findAllSites() {
        return siteRepository.findAll();
    }

    @Override
    public Site saveSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public Site updateSite(Long id, Site site) {
        Site siteDb = siteRepository.findById(id).get();
        //valide que no actualice nulo o vacio
        if(Objects.nonNull(site.getCode()) &&
                !"".equalsIgnoreCase(site.getCode())){
            siteDb.setCode(site.getCode());
        }

        if(Objects.nonNull(site.getCoordinates()) &&
                !"".equalsIgnoreCase(site.getCoordinates())){
            siteDb.setCoordinates(site.getCoordinates());
        }

        if(Objects.nonNull(site.getName()) &&
                !"".equalsIgnoreCase(site.getName())){
            siteDb.setName(site.getName());
        }

        return siteRepository.save(siteDb);
    }

    @Override
    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }
}
