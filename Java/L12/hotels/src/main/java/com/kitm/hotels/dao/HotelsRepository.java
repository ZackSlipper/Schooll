package com.kitm.hotels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitm.hotels.entity.Hotel;

public interface HotelsRepository extends JpaRepository<Hotel, Long> {
	
}
