package com.neosoft.parkingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.parkingsystem.entity.BookingDetail;
import com.neosoft.parkingsystem.entity.Slot;
import com.neosoft.parkingsystem.service.BookingService;
import com.neosoft.parkingsystem.service.SlotService;

@Controller
@RequestMapping
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private SlotService slotService;

	@PostMapping("/bookslot")
	public String bookSlot(@ModelAttribute("bookingDetail") BookingDetail bookingDetail) {
		bookingDetail.setStartTime(bookingDetail.getStartTimeText());
		bookingDetail.setEndTime(bookingDetail.getEndTimeText());
		Slot slot = slotService.getSlotByName(bookingDetail.getSlotName());
		slot.setIsBooked(true);
		bookingDetail.setSlot(slot);
		System.out.println(bookingDetail);
		bookingService.saveBooking(bookingDetail);
		return "redirect:/hello";
	}
	
//	@PostMapping("/bookslot")
//	public String bookSlot(Model model) {
//		System.out.println(model);
//		return "redirect:/hello";
//	}
	
	@GetMapping("/hello")
	public String getSlots(Model model) {
		model.addAttribute("slots", slotService.getSlots());
		return "hello";
	}
}
