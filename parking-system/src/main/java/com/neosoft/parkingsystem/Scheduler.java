package com.neosoft.parkingsystem;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.neosoft.parkingsystem.entity.BookingDetail;
import com.neosoft.parkingsystem.entity.Slot;
import com.neosoft.parkingsystem.service.BookingService;
import com.neosoft.parkingsystem.service.SlotService;

@Component
public class Scheduler {
	@Autowired
	private BookingService bookingService;
	@Autowired
	private SlotService slotService;
	
   @Scheduled(fixedRate = 1000*30)
   public void fixedRateSch() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      Date now = new Date();
      String strDate = sdf.format(now);
      
      for(BookingDetail bookingDetail:bookingService.getAllBookingDetails()) {
    	  if(bookingDetail.getEndTime().isBefore(LocalDateTime.now())) {
    		  Slot slot = bookingDetail.getSlot();
    		  slot.setIsBooked(false);
    		  slotService.saveSlot(slot);
    	  }
      }
      
      //System.out.println("Fixed Rate scheduler:: " + strDate);
   }
}