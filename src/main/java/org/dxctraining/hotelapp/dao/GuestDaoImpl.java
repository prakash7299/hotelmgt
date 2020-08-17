package org.dxctraining.hotelapp.dao;


import org.dxctraining.hotelapp.entities.Guest;
import org.dxctraining.hotelapp.exceptions.GuestNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GuestDaoImpl implements IGuestDao{

    //equivalent to @Autowired
    //@Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Guest findGuestById(int id) {
        Guest guest=entityManager.find(Guest.class,id);
        if(guest==null){
            throw new GuestNotFoundException("guest not found for id="+id);
        }
        return guest;
    }

    @Override
    public Guest update(Guest guest) {
        guest=entityManager.merge(guest);
        return guest;
    }

    @Override
    public Guest save(Guest guest) {
        entityManager.persist(guest);
        return guest;
    }

    @Override
    public void remove(int id) {
     Guest guest= findGuestById(id) ;
     entityManager.remove(guest);
    }

    @Override
    public Guest findGuestByName(String guestName){
        String jpaql="from Employee where name=:ename";
        Query query= entityManager.createQuery(jpaql);
        query.setParameter("ename",guestName);
        List<Guest>list=query.getResultList();
        Guest guest=null;
        if(!list.isEmpty()){
           guest=list.get(0);
        }
        return guest;
    }

}
