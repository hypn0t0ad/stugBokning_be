package com.example.stugbokning_be.repository;

import com.example.stugbokning_be.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query("SELECT b FROM BookingEntity b WHERE b.cabin.id = :stugaId")
    Collection<BookingEntity> findByStugaId(@Param("stugaId") long stugaId);
}
