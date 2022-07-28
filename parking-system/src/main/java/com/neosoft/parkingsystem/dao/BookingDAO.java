package com.neosoft.parkingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.parkingsystem.entity.BookingDetail;
import com.neosoft.parkingsystem.entity.Slot;

public interface BookingDAO extends JpaRepository<BookingDetail, Integer>{

}
