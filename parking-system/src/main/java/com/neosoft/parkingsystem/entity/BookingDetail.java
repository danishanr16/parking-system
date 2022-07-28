package com.neosoft.parkingsystem.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class BookingDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingID ;
	private String name;
	private boolean isBooked;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	@Transient
	private String startTimeText;
	@Transient
	private String endTimeText;
	@Transient
	private String slotName;
	
	public String getSlotName() {
		return slotName;
	}
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
	@ManyToOne
	private Slot slot;
	public Integer getBookingID() {
		return bookingID;
	}
	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public String getStartTimeText() {
		return startTimeText;
	}
	public void setStartTimeText(String startTimeText) {
		this.startTimeText = startTimeText;
	}
	public String getEndTimeText() {
		return endTimeText;
	}
	public void setEndTimeText(String endTimeText) {
		this.endTimeText = endTimeText;
	}
	public void setStartTime(String startTime) {
		System.out.println("startTime "+getStartTimeText());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm a");// MM/dd/yyyy HH:mm a
		LocalDateTime dateTime = LocalDateTime.parse(getStartTimeText(), formatter);
		this.startTime = dateTime;
	}
	public void setEndTime(String endTime) {
		System.out.println("endTime "+getEndTimeText());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
		LocalDateTime dateTime = LocalDateTime.parse(getEndTimeText(), formatter);
		this.endTime = dateTime;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	@Override
	public String toString() {
		return "BookingDetail [bookingID=" + bookingID + ", name=" + name + ", isBooked=" + isBooked + ", startTime="
				+ startTime + ", endTime=" + endTime + ", startTimeText=" + startTimeText + ", endTimeText="
				+ endTimeText + ", slot=" + slot + "]";
	}
	
}
