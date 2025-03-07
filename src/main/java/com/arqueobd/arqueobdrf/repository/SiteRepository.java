package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//permite acceder a datos de la interfaz de JPA Repository que pertenece a Spring Data -- Permite realizar consultas de persistencia de forma rapida.
public interface SiteRepository extends JpaRepository<Site,Long> {

    //consulta que trae un registro de la entidad site donde su atributo pasado es name // consulta con JPQL
    @Query("SELECT s FROM Site s WHERE s.name = :name")
    Optional<Site> findSiteByNameWithJPQL(String name);

    //CONSULTA CON INVERSIÓN DE CONTROL
    Optional<Site> findByName(String name);

    //Sistema para que ignore Mayus/minus
    Optional<Site> findByNameIgnoreCase(String name);

}
