package com.kitm.hotels.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitm.hotels.dao.HotelsRepository;
import com.kitm.hotels.entity.Hotel;

@Service
public class HotelsServiceImpl implements HotelsService {
	private HotelsRepository hotelRepository;

	@Autowired
	public HotelsServiceImpl(HotelsRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findById(Long id) {
		Optional<Hotel> result = hotelRepository.findById(id);
		Hotel hotel = null;
		if (result.isPresent()) {
			hotel = result.get();
		} else {
			throw new RuntimeException("Did not find hotel id - " + id);
		}
		return hotel;
	}

	@Override
	public Hotel save(Hotel hotel){
		return hotelRepository.save(hotel);
	}

	@Override
	public void deleteById(Long id) {
		hotelRepository.deleteById(id);
	}
}
