package org.dxctraining.dao;

import java.util.List;

import org.dxctraining.entities.Guest;

public interface IGuestDao {
	List<Guest> findAll();

	void register(Guest guest);

	Guest findById(String id);

	Guest updateName(String id, String newName);

	void delete(String id);

	Guest updateCost(String id, double newCost);

}
