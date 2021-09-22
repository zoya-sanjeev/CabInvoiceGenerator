package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {

	public int numberOfRides;
	public double totalFare;
	public double averageFare;

	public InvoiceSummary(int numberOfRides, double totalFare) {
		this.numberOfRides=numberOfRides;
		this.totalFare=totalFare;
		this.averageFare=this.totalFare/this.numberOfRides;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) o;
		return numberOfRides == that.numberOfRides && 
				Double.compare(that.totalFare, this.totalFare) == 0 &&
				Double.compare(that.averageFare, this.averageFare) == 0;
	}

}
