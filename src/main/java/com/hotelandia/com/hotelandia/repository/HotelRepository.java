package com.hotelandia.com.hotelandia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelandia.com.hotelandia.model.DadosHotel;

@Repository
public interface HotelRepository extends JpaRepository<DadosHotel, Integer>{

}
