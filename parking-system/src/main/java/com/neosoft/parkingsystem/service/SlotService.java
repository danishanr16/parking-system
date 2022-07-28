package com.neosoft.parkingsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.parkingsystem.dao.SlotsDAO;
import com.neosoft.parkingsystem.entity.Slot;

@Service
public class SlotService {
	
	@Autowired
	private SlotsDAO dao;
	
	public Map<String, Object> getSlots() {
		Map<String, Object> resMap= new HashMap<>();
		List<Slot> allSlots = dao.findAll();
		List<Slot> slotA = allSlots.stream().filter(slot->slot.getName().startsWith("A")).map(slot->slot).collect(Collectors.toList());
		List<Slot> slotB = allSlots.stream().filter(slot->slot.getName().startsWith("B")).map(slot->slot).collect(Collectors.toList());
		List<Slot> slotC = allSlots.stream().filter(slot->slot.getName().startsWith("C")).map(slot->slot).collect(Collectors.toList());
		resMap.put("slotA", slotA);
		resMap.put("slotB", slotB);
		resMap.put("slotC", slotC);
		resMap.put("totalSlots", allSlots.size());
		int bookedSlots = allSlots.stream().filter(slot->slot.getIsBooked()).collect(Collectors.toList()).size();
		resMap.put("bookedSlots", bookedSlots);
		int availableSlots = allSlots.stream().filter(slot->!slot.getIsBooked()).collect(Collectors.toList()).size();
		resMap.put("availableSlots", availableSlots);
		List<Slot> openSlotA = slotA.stream().filter(slot->!slot.getIsBooked()).collect(Collectors.toList());
		List<Slot> openSlotB = slotB.stream().filter(slot->!slot.getIsBooked()).collect(Collectors.toList());
		List<Slot> openSlotC = slotC.stream().filter(slot->!slot.getIsBooked()).collect(Collectors.toList());
		resMap.put("openSlotA", openSlotA);
		resMap.put("openSlotB", openSlotB);
		resMap.put("openSlotC", openSlotC);
		return resMap;
	}
	
	public Slot getSlotByName(String name) {
		List<Slot> list = dao.findByName(name);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
		
	}
	public Slot saveSlot(Slot slot) {
		 Slot save = dao.save(slot);
		 System.out.println("SLot-> "+save);
		 return save;
	}
}
