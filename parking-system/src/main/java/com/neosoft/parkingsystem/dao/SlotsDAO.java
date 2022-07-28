package com.neosoft.parkingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.parkingsystem.entity.Slot;

public interface SlotsDAO extends JpaRepository<Slot, Integer>{
	
	List<Slot> findByName(String name);

}
