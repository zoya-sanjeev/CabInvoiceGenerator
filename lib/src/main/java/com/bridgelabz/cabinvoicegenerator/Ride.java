package com.bridgelabz.cabinvoicegenerator;

public class Ride {

	public double distance;
	public int time;
	RideType type;
	enum RideType{
		NORMAL_RIDE,
		PREMIUM_RIDE
	}

	public Ride(double distance, int time, RideType ride) {
		this.distance=distance;
		this.time=time;
		this.type=type;
	}


}
