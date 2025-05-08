package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    //consultas personalizadas con @query. El número selecciona el parámetro que será comparado
    @Query("select c from Campaign c where c.campaignCode = ?1")
    Campaign getCampaignByCampaignCode(String campaignCode);

    //para traer un campo de la base de datos a través de otro campo
    @Query("select c.description from Campaign c where c.campaignCode = ?1")
    String getCampaignDescriptionByCampaignCode(String campaignCode);

    //ejemplo de consulta nativa
    @Query(
            value="select * from tbl_campaign where campaign_code = ?1",
            nativeQuery = true
    )
    Campaign getCampaignByCampaignCodeNative(String campaignCode);

    //si hay varios parametros de consulta. Evitar bad smells. Con Param marcas la label a seleccionar
    @Query(
            value="select * from tbl_campaign where campaign_code = :campaignCode",
            nativeQuery = true
    )
    Campaign getCampaignByCampaignCodeNativeParam(@Param("campaignCode") String campaignCode);

}
