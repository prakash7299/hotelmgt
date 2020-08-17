package org.dxctraining.hotelapp.ui;

import java.util.List;


import javax.annotation.PostConstruct;
import org.dxctraining.hotelapp.entities.Guest;
import org.dxctraining.hotelapp.exceptions.*;
import org.dxctraining.hotelapp.service.GuestServiceImpl;
import org.dxctraining.hotelapp.service.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class GuestUi {
	
	@Autowired
	private IGuestService service;

	@PostConstruct
	private void runapp() {
		try {
			Guest guest1 = new Guest("prakash", 8000);
			Guest guest2 = new Guest("praveen", 2000);
			Guest guest3 = new Guest("surya", 9000);
			Guest guest4 = new Guest("karthik", 7000);
			service.save(guest1);
			service.save(guest2);
			service.save(guest3);
			service.save(guest4);
			int id1 = guest1.getId();
			Guest fetched = service.findGuestById(id1);
			System.out.println("details"+fetched.getId()+"name"+fetched.getName());
		} catch (InvalidArgumentException e) {
			e.printStackTrace();
		}

		catch (GuestNotFoundException e) {
			e.printStackTrace();
		}

	}

}
