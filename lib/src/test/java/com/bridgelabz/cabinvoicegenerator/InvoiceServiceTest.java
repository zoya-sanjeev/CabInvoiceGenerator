package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class InvoiceServiceTest {
	
	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25.0, fare);
	}

}
