package org.dxctraining.hotelapp.dao;

import java.util.List;

import org.dxctraining.hotelapp.entities.Guest;


public interface IGuestDao {
	Guest findGuestById(int id);

    Guest update(Guest guest);

    Guest save(Guest guest);

    void remove(int id);

    Guest findGuestByName(String guestName);
}
