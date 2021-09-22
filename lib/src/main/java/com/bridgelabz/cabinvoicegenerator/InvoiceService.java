package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

import com.bridgelabz.cabinvoicegenerator.Ride.RideType;

public class InvoiceService {

	public InvoiceSummary getInvoice(int userId) {
		List<Ride> rides=RideRepository.rides.get(userId);
		RideType type = null;
		Ride[] rideArray = new Ride[rides.size()];
		int index=0;
		for(Ride ride: rides) {
			rideArray[index++]=ride;
			type=ride.type;
		}
		InvoiceSummary summary= new InvoiceGenerator().calculateFare(rideArray,type);
		return summary;
	}

}
