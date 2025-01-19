package com.example.stugbokning_be.repository;

import com.example.stugbokning_be.entity.CabinEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CabinRepository extends JpaRepository<CabinEntity, Long> {

}
