package com.bridgelabz.cabinvoicegenerator;

import org.junit.Test;


public class InvoiceServiceTest {
	
	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(25, fare);
	}

}
