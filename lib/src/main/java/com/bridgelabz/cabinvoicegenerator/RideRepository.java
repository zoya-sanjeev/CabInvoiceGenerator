package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
	public int userId;
	public List<Ride> rides;
	public RideRepository(int userId) {
		this.userId=userId;
		this.rides= new ArrayList<>();
	}
	public void add(Ride ride) {
		this.rides.add(ride);	
	}

}
