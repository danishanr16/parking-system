package com.neosoft.parkingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.neosoft.parkingsystem.dao.SlotsDAO;
import com.neosoft.parkingsystem.entity.Slot;

@Component
public class MyRunner implements CommandLineRunner{
	
	@Autowired
	private SlotsDAO repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for(char c='A';c<='C';c++) {
			for(int i=1;i<=10;i++) {
				Slot slot = new Slot(String.valueOf(c)+i,false);
				repository.save(slot);
			}
		}
	}

}
