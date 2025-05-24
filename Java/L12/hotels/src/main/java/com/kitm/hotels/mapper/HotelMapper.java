package com.kitm.hotels.mapper;

import java.time.LocalDateTime;

import com.kitm.hotels.dto.HotelCreateDTO;
import com.kitm.hotels.dto.HotelResponseDTO;
import com.kitm.hotels.entity.Hotel;

public class HotelMapper {
	public static Hotel toEntity(HotelCreateDTO dto) {
		Hotel hotel = new Hotel();

		hotel.setName(dto.getName());
		hotel.setAddress(dto.getAddress());
		hotel.setRankingAverage(dto.getRankingAverage());
		hotel.setRoomPrice(dto.getRoomPrice());
		hotel.setPriceDiscount(dto.getPriceDiscount());
		hotel.setComfort(dto.getComfort());
		hotel.setSummary(dto.getSummary());
		hotel.setDescription(dto.getDescription());
		hotel.setImageCover(dto.getImageCover());
		hotel.setCreatedAt(LocalDateTime.now());
		hotel.setUpdatedAt(LocalDateTime.now());

		return hotel;
	}
	
	public static HotelResponseDTO toResponse(Hotel hotel) {
		HotelResponseDTO dto = new HotelResponseDTO();
		
		dto.setId(hotel.getId());
		dto.setName(hotel.getName());
		dto.setAddress(hotel.getAddress());
		dto.setRankingAverage(hotel.getRankingAverage());
		dto.setRoomPrice(hotel.getRoomPrice());
		dto.setPriceDiscount(hotel.getPriceDiscount());
		dto.setComfort(hotel.getComfort());
		dto.setSummary(hotel.getSummary());
		dto.setDescription(hotel.getDescription());
		dto.setImageCover(hotel.getImageCover());
		dto.setCreatedAt(hotel.getCreatedAt());
		dto.setUpdatedAt(hotel.getUpdatedAt());

		return dto;
	}
}
