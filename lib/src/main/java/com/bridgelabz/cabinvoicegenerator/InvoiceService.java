package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public class InvoiceService {

	public InvoiceSummary getInvoice(int userId) {
		List<Ride> rides=RideRepository.rides.get(userId);
		Ride[] rideArray = new Ride[rides.size()];
		int index=0;
		for(Ride ride: rides) {
			rideArray[index++]=ride;
		}
		InvoiceSummary summary= new InvoiceGenerator().calculateFare(rideArray);
		return summary;
	}

}
