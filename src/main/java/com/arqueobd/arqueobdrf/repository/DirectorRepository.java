package com.arqueobd.arqueobdrf.repository;

import com.arqueobd.arqueobdrf.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
