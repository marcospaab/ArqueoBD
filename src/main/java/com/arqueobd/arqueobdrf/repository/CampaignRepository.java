package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    //trae registro por su code, cuidado para que encuentre el campaigncode, ya que el nombre del método pasa por jpa
    Optional<Campaign> findByCampaignCode(String campaignCode);

    List<Campaign> findByCampaignCodeContaining(String campaignCode);

    List<Campaign> findByStartDateNotNull();

    //llamando a la jpa de la entidad embebida en campaign
    List<Campaign> findByStorehouse_StorehouseName(String storehouseName);

    //ahora lo mismo con containing
    List<Campaign> findByStorehouse_StorehouseNameContaining(String storehouseName);

}
