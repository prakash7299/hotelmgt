package org.dxctraining.entities;

public class Guest {
	private String id;
	private String name;
	private double roomCost;

	public Guest(String name, double roomCost) {
		this.name = name;
		this.roomCost = roomCost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		int hash = id.hashCode();
		return hash;
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
		boolean isequal = this.id.equals(that.id);
		return isequal;
	}

}
