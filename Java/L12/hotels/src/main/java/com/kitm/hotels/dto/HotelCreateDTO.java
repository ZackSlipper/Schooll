package com.kitm.hotels.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class HotelCreateDTO {

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Address is mandatory")
	private String address;

	@DecimalMin(value = "1.0", message = "Ranking average must be greater than or equal to 1.0")
	@DecimalMin(value = "5.0", message = "Ranking average must be less than or equal to 5.0")
	private Double rankingAverage;

	@NotNull(message = "Room price is mandatory")
	@Positive(message = "Room price must be positive")
	private Double roomPrice;

	private Double priceDiscount;

	@NotNull(message = "Comfort is mandatory")
	@Min(value = 1, message = "Comfort must be greater than or equal to 1")
	@Max(value = 7, message = "Comfort must be less than or equal to 7")
	private Integer comfort;

	@NotBlank(message = "Summary is mandatory")
	@Size(max = 150, message = "Summary must be less than or equal to 150 characters")
	private String summary;

	private String description;

	private String imageCover;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getRankingAverage() {
		return rankingAverage;
	}

	public void setRankingAverage(Double rankingAverage) {
		this.rankingAverage = rankingAverage;
	}

	public Double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Double getPriceDiscount() {
		return priceDiscount;
	}

	public void setPriceDiscount(Double priceDiscount) {
		this.priceDiscount = priceDiscount;
	}

	public Integer getComfort() {
		return comfort;
	}

	public void setComfort(Integer comfort) {
		this.comfort = comfort;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageCover() {
		return imageCover;
	}

	public void setImageCover(String imageCover) {
		this.imageCover = imageCover;
	}
}
