package com.kitm.hotels.service;

import java.util.List;

import com.kitm.hotels.entity.Hotel;

public interface HotelsService {
	List<Hotel> findAll();

	Hotel findById(Long id);

	Hotel save(Hotel hotel);

	void deleteById(Long id);
}
