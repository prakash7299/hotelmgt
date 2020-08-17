package org.dxctraining.hotelapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guests")//table name
public class Guest {
	
	@Id
    @GeneratedValue
	private int id;
	private String name;
	private double roomCost;

    public Guest() {
		
	}

	public Guest(String name, double roomCost) {
		this.name = name;
		this.roomCost = roomCost;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object org) {
		if (this == org) {
			return true;
		}

		if (org == null || !(org instanceof Guest)) {
			return false;
		}

		Guest that = (Guest) org;
		boolean isequal = this.id==that.id;
		return isequal;
	}

}
