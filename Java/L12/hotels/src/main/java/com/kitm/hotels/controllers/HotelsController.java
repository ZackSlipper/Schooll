package com.kitm.hotels.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kitm.hotels.dto.HotelCreateDTO;
import com.kitm.hotels.dto.HotelResponseDTO;
import com.kitm.hotels.entity.Hotel;
import com.kitm.hotels.mapper.HotelMapper;
import com.kitm.hotels.service.HotelsService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/hotels")
public class HotelsController {
	private HotelsService hotelsService;
	private ObjectMapper objectMapper;

	@Autowired
	public HotelsController(HotelsService hotelsService, ObjectMapper objectMapper) {
		this.hotelsService = hotelsService;
		this.objectMapper = objectMapper;
	}

	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Map<String, Object>> findAll() {
		List<HotelResponseDTO> hotels = hotelsService.findAll()
			.stream()
			.map(HotelMapper::toResponse)
			.collect(Collectors.toList());
			
		
		Map<String, Object> response = Map.of(
			"status", "Success",
			"timestamp", System.currentTimeMillis(),
			"data", hotels
		);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<HotelResponseDTO> findById(@PathVariable Long id) {
		Optional<Hotel> results = Optional.ofNullable(hotelsService.findById(id));
		return results.map(hotel -> ResponseEntity.ok(HotelMapper.toResponse(hotel)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HotelResponseDTO> addHotel(@Valid @RequestBody HotelCreateDTO hotelDTO) {
		Hotel saved = hotelsService.save(HotelMapper.toEntity(hotelDTO));
		return ResponseEntity.ok(HotelMapper.toResponse(saved));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
		Hotel hotel = hotelsService.findById(id);
		if (hotel == null) {
			return ResponseEntity.notFound().build();
		}

		hotelsService.deleteById(id);
		return ResponseEntity.ok("Deleted hotel id - " + id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HotelResponseDTO> updateHotel(@PathVariable Long id, @RequestBody HotelCreateDTO hotelDTO) {
		Hotel existingHotel = hotelsService.findById(id);
		if (existingHotel == null) {
			return ResponseEntity.notFound().build();
		}

		Hotel updatedHotel = HotelMapper.toEntity(hotelDTO);
		updatedHotel.setId(id);
		updatedHotel.setCreatedAt(existingHotel.getCreatedAt());
		updatedHotel.setUpdatedAt(LocalDateTime.now());

		Hotel hotel = hotelsService.save(updatedHotel);

		return ResponseEntity.ok(HotelMapper.toResponse(hotel));
	}

	@PatchMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HotelResponseDTO> patchHotel(@PathVariable Long id, @RequestBody Map<String, Object> pathPayload) {
		Hotel existingHotel = hotelsService.findById(id);
		if (existingHotel == null) {
			return ResponseEntity.notFound().build();
		}

		if (pathPayload == null || pathPayload.isEmpty() || pathPayload.containsKey("id")) {
			return ResponseEntity.badRequest().body(null);
		}

		ObjectNode hotelNode = objectMapper.convertValue(existingHotel, ObjectNode.class);
		ObjectNode pathNode = objectMapper.convertValue(pathPayload, ObjectNode.class);
		hotelNode.setAll(pathNode);

		Hotel patchedHotel = objectMapper.convertValue(hotelNode, Hotel.class);
		Hotel savedHotel = hotelsService.save(patchedHotel);

		return ResponseEntity.ok(HotelMapper.toResponse(savedHotel));
	}
}
