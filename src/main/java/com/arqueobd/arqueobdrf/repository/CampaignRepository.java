package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
