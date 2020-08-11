package org.dxctraining.service;

import java.util.List;


import org.dxctraining.dao.GuestDaoImpl;
import org.dxctraining.dao.IGuestDao;
import org.dxctraining.entities.Guest;
import org.dxctraining.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements IGuestService {
	@Autowired
	private IGuestDao dao;

	@Override
	public List<Guest> findAll() {
		List<Guest> list = dao.findAll();
		return list;
	}

	@Override
	public Guest findById(String id) {
		checkId(id);
		Guest guest = dao.findById(id);
		return guest;
	}

	public void checkId(String id) {
		int idno = Integer.parseInt(id);
		if (idno < 1) {
			throw new InvalidArgumentException("id cant be negative, id passed=" + id);
		}
	}

	@Override
	public void register(Guest guest) {
		checkGuest(guest);
		dao.register(guest);

	}

	public void checkGuest(Guest guest) {
		if (guest == null) {
			throw new InvalidArgumentException("Guest cant be null");

		}
	}

	@Override
	public Guest updateName(String id, String newName) {
		checkId(id);
		checkName(newName);
		Guest guest = dao.updateName(id, newName);
		return guest;
	}

	public void checkName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException("name cant be null or empty");
		}
	}

	@Override
	public Guest updateCost(String id, double newCost) {
		checkId(id);
		checkCost(newCost);
		Guest guest = dao.updateCost(id, newCost);
		return guest;
	}

	public void checkCost(double cost) {
		Double newCost = cost;
		if (newCost == null) {
			throw new InvalidArgumentException("cost cant be null");
		}
	}

	@Override
	public void delete(String id) {
		checkId(id);
		dao.delete(id);
	}

}
