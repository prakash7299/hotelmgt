package org.dxctraining.hotelapp.service;

import java.util.List;


import org.dxctraining.hotelapp.dao.GuestDaoImpl;
import org.dxctraining.hotelapp.dao.IGuestDao;
import org.dxctraining.hotelapp.entities.Guest;
import org.dxctraining.hotelapp.exceptions.GuestNotFoundException;
import org.dxctraining.hotelapp.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class GuestServiceImpl implements IGuestService {
	@Autowired
    private IGuestDao dao;

    @Override
    public Guest findGuestById(int id) {
       Guest guest= dao.findGuestById(id);
        return guest;
    }


    @Override
    public Guest update(Guest guest) {
        validate(guest);
        guest=dao.update(guest);
        return guest;
    }

    @Override
    public Guest save(Guest guest) {
        validate(guest);
        guest=dao.save(guest);
        return guest;
    }

    @Override
    public void remove(int id) {
       dao.remove(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public Guest findGuestByName(String guestName) {
       Guest guest =dao.findGuestByName(guestName);
       return guest;
    }
}
