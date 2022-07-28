package com.neosoft.parkingsystem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer slotID;
	private String name;
	private Boolean  isBooked;
	@OneToMany(mappedBy = "slot")
	private List<BookingDetail> bookingDetails;
	
	public List<BookingDetail> getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(List<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	public Slot(String name, boolean isBooked) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.isBooked=isBooked;
	}
	public Slot() {
	}
	public Integer getSlotID() {
		return slotID;
	}
	public void setSlotID(Integer slotID) {
		this.slotID = slotID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsBooked() {
		return isBooked;
	}
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}
	@Override
	public String toString() {
		return "Slot [name=" + name + ", isBooked=" + isBooked + "]";
	}
	
}
