package com.neosoft.parkingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.parkingsystem.dao.BookingDAO;
import com.neosoft.parkingsystem.entity.BookingDetail;

@Service
public class BookingService {

	@Autowired
	private BookingDAO dao;
	
	public void saveBooking(BookingDetail bookingDetail) {
		BookingDetail save = dao.save(bookingDetail);
		System.out.println("Booking detail saved!\n"+save);
	}
	
	public List<BookingDetail> getAllBookingDetails() {
		return dao.findAll();
	}
}
