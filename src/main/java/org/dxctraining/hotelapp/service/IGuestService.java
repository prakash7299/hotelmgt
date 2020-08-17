package org.dxctraining.hotelapp.service;

import java.util.List;

import org.dxctraining.hotelapp.entities.Guest;

public interface IGuestService {
	Guest findGuestById(int id);

    Guest update(Guest guest);

    Guest save(Guest guest);

    void remove(int id);

    Guest findGuestByName(String guestName);
}
