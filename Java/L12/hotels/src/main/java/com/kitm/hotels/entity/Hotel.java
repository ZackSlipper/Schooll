package com.kitm.hotels.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "ranking_average")
	private Double rankingAverage;

	@Column(name = "room_price")
	private Double roomPrice;

	@Column(name = "price_discount")
	private Double priceDiscount;

	@Column(name = "comfort")
	private Integer comfort;

	@Column(name = "summary")
	private String summary;

	@Column(name = "description")
	private String description;

	@Column(name = "image_cover")
	private String imageCover;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public Hotel() {
	}

	public Hotel(String name, String address, Double rankingAverage, Double roomPrice, Double priceDiscount,
			Integer comfort, String summary, String description, String imageCover) {
		this.name = name;
		this.address = address;
		this.rankingAverage = rankingAverage;
		this.roomPrice = roomPrice;
		this.priceDiscount = priceDiscount;
		this.comfort = comfort;
		this.summary = summary;
		this.description = description;
		this.imageCover = imageCover;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", rankingAverage=" + rankingAverage
				+ ", roomPrice=" + roomPrice + ", priceDiscount=" + priceDiscount + ", comfort=" + comfort
				+ ", summary=" + summary + ", description=" + description + ", imageCover=" + imageCover
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
