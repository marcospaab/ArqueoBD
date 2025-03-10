package com.arqueobd.arqueobdrf.service;


import com.arqueobd.arqueobdrf.entity.Site;
import com.arqueobd.arqueobdrf.error.SiteNotFoundException;
import com.arqueobd.arqueobdrf.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

//capa de servicio y logica a desarrollar
@Service
public class SiteServiceImpl implements SiteService{

    //inyecta el repositorio desde spring
    @Autowired
    SiteRepository siteRepository;

    //recupera todos los datos de la tabla sites
    @Override
    public List<Site> findAllSites() throws SiteNotFoundException {
        List<Site> site = siteRepository.findAll();
        if(site.isEmpty()){
            throw new SiteNotFoundException("No se ha encontrado ningún registro en la Base de Datos.");
        }
        return site;
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
    public void deleteSite(Long id) throws SiteNotFoundException{
        //verificar si el site con ese id existe
        Optional<Site> siteOptional = siteRepository.findById(id);
        if(siteOptional.isPresent()){
            siteRepository.deleteById(id);
        }else{
            throw new SiteNotFoundException("No se ha encontrado ningún registro con el ID "+id+" que eliminar.");
        }
    }

    @Override
    public Optional<Site> findSiteByWithJPQL(String name) throws SiteNotFoundException {
        Optional<Site> site = siteRepository.findSiteByNameWithJPQL(name);
        if(!site.isPresent()){
            throw new SiteNotFoundException("No existe un yacimiento con el nombre de " + name+".");
        }
        return site;
    }

    @Override
    public Optional<Site> findByName(String name) throws SiteNotFoundException {
        Optional<Site> site = siteRepository.findByName(name);
        if(!site.isPresent()){
            throw new SiteNotFoundException("No existe un yacimiento con el nombre de " + name+".");
        }
        return site;
    }

    @Override
    public Optional<Site> findByNameIgnoreCase(String name) throws SiteNotFoundException{
        Optional<Site> site = siteRepository.findByNameIgnoreCase(name);
        if(!site.isPresent()){
            throw new SiteNotFoundException("No existe un yacimiento con el nombre de " + name+".");
        }
        return site;
    }

    @Override
    public Site findSiteById(Long id) throws SiteNotFoundException {
        Optional<Site> site = siteRepository.findById(id);
        if(!site.isPresent()){
            throw new SiteNotFoundException("No existe un yacimiento con el ID "+id+".");
        }
        return site.get();
    }
}
