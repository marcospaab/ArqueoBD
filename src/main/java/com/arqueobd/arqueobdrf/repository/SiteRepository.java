package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

//permite acceder a datos de la interfaz de JPA Repository que pertenece a Spring Data
public interface SiteRepository extends JpaRepository<Site,Long> {


}
