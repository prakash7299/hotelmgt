package org.dxctraining.dao;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dxctraining.entities.Guest;
import org.dxctraining.exceptions.GuestNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDaoImpl implements IGuestDao {
	private Map<String, Guest> store = new HashMap<>();
	private int generatedId = 1;

	private String generateId() {
		Integer idInteger = generatedId++;
		String idString = idInteger.toString();
		return idString;
	}

	@Override
	public List<Guest> findAll() {
		Collection<Guest> values = store.values();
		List<Guest> list = new ArrayList<>();
		for (Guest value : values) {
			list.add(value);
		}
		return list;
	}

	@Override
	public void register(Guest guest) {
		String id = generateId();
		store.put(id, guest);
		guest.setId(id);
	}

	@Override
	public Guest updateName(String id, String newName) {
		Guest guest = findById(id);
		guest.setName(newName);
		return guest;
	}

	@Override
	public Guest updateCost(String id, double newCost) {
		Guest guest = findById(id);
		guest.setRoomCost(newCost);
		return guest;
	}

	@Override
	public Guest findById(String id) {
		Guest guest = store.get(id);
		if (guest == null) {
			throw new GuestNotFoundException("guest not found for id=" + id);
		}
		return guest;
	}

	@Override
	public void delete(String id) {
		store.remove(id);
	}
}
