package com.bridgelabz.cabinvoicegenerator;


import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator=null;
	
	@Before
	public void setUp() throws Exception{
		invoiceGenerator= new InvoiceGenerator();
	}
	
	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25.0, fare,0.0);
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary= new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}	
	
	@Test
	public void givenUserId_shouldReturnListOfRides() {
		InvoiceService invoiceService= new InvoiceService();
		int userId=12;
		Ride ride1= new Ride(2.0,5);
		Ride ride2=new Ride(0.1,1);
		RideRepository rideRepository =new RideRepository(userId);
		rideRepository.add(ride1);
		rideRepository.add(ride2);
		InvoiceSummary summary=invoiceService.getInvoice(12);
		Invoice
	}

}
