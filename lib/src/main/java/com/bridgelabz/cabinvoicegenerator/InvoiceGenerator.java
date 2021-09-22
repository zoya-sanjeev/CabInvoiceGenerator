package com.bridgelabz.cabinvoicegenerator;

import com.bridgelabz.cabinvoicegenerator.Ride.RideType;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE_NORMAL = 5;
	
	private static final double MINIMUM_FARE_PREMIUM=20;
	private static final int COST_PER_TIME_PREMIUM = 2;
	private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;

	public double calculateFare(double distance, int time, RideType type) {
		
		double totalFare=0;
		if (type == RideType.NORMAL_RIDE) {
			totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
			return Math.max(MINIMUM_FARE_NORMAL, totalFare);
		} else {
			totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
			return Math.max(MINIMUM_FARE_PREMIUM, totalFare);
		}
	}

	public InvoiceSummary calculateFare(Ride[] rides, RideType type) {
		double totalFare=0.0;
		for(Ride ride: rides) {
			double fare=this.calculateFare(ride.distance, ride.time, type);
			totalFare+=fare;
		}
		return new InvoiceSummary(rides.length, totalFare);
	}


}

