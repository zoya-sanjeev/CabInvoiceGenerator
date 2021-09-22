package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	public double distance;
	public int time;
	
	enum RideType{
		NORMAL_RIDE,
		PREMIUM_RIDE
	}

	public Ride(double distance, int time) {
		this.distance=distance;
		this.time=time;
	}


}
