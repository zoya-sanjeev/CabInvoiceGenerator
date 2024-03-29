package com.bridgelabz.cabinvoicegenerator;


import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.cabinvoicegenerator.Ride.RideType;


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
		double fare = invoiceGenerator.calculateFare(distance, time, RideType.NORMAL_RIDE);
		Assert.assertEquals(25.0, fare,0.0);
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time, RideType.NORMAL_RIDE);
		assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5, RideType.NORMAL_RIDE), new Ride(0.1, 1, RideType.NORMAL_RIDE) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides, RideType.NORMAL_RIDE);
		InvoiceSummary expectedSummary= new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}	
	
	@Test
	public void givenUserId_shouldReturnListOfRides() {
		InvoiceService invoiceService= new InvoiceService();
		int userId=12;
		Ride ride1= new Ride(2.0,5, RideType.NORMAL_RIDE);
		Ride ride2=new Ride(0.1,1,RideType.NORMAL_RIDE);
		RideRepository rideRepository =new RideRepository(userId);
		rideRepository.add(ride1, userId);
		rideRepository.add(ride2, userId);
		InvoiceSummary summary=invoiceService.getInvoice(12);
		InvoiceSummary expectedSummary= new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void givenPremiumDistanceAndTime_ShouldReturnTotalPremiumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time,RideType.PREMIUM_RIDE);
		assertEquals(40, fare, 0.0);
	}
	
	@Test
	public void givenPremiumLessDistanceAndTime_ShouldReturnPremiumMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time,RideType.PREMIUM_RIDE);
		assertEquals(20, fare, 0.0);
	}

}
