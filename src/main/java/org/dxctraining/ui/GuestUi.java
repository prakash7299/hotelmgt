package org.dxctraining.ui;

import java.util.List;


import javax.annotation.PostConstruct;
import org.dxctraining.JavaConfig;
import org.dxctraining.entities.Guest;
import org.dxctraining.exceptions.*;
import org.dxctraining.service.GuestServiceImpl;
import org.dxctraining.service.IGuestService;
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
			service.register(guest1);
			service.register(guest2);
			service.register(guest3);
			service.register(guest4);
			service.updateName(guest1.getId(), "prashanth");
			Guest fetched = service.findById("1");
			service.delete("2");
			service.updateCost("4", 500);
			display(fetched);
			displayAll();
		} catch (InvalidArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		catch (GuestNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("some thing went wrong");
		}
	}

	public void displayAll() {
		List<Guest> list = service.findAll();
		for (Guest guest : list) {
			display(guest);
		}
	}

	public void display(Guest guest) {
		System.out.println("Guest id :" + guest.getId() + " Guest name : " + guest.getName() + " Room Cost : "+ guest.getRoomCost());

	}
}
