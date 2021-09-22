package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RideRepository {
	public static HashMap<Integer, List<Ride>> rides=new HashMap<>();
	public RideRepository(int userId) {
		this.rides= new HashMap<>();
	}
	public void add(Ride ride, int userId) {
		if(rides.containsKey(userId)) {
			List<Ride> rideCurrent=rides.get(userId);
			rideCurrent.add(ride);
		}else {
			List<Ride> rideCurrent=new ArrayList<>();
			rideCurrent.add(ride);	
			rides.put(userId,rideCurrent);
		}
	}
	
	public List<Ride> getRides(int userId){
		return rides.get(userId);
	}

}
