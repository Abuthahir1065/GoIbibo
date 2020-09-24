package com.atmecs.goibibo;

import org.testng.annotations.Test;

import browser.SetUp;
import pageActions.GoIbiboBookAction;

public class BookingClass extends SetUp {
	@Test(priority = 2)
	public void book() throws InterruptedException {
		GoIbiboBookAction bookTicket = new GoIbiboBookAction();
		bookTicket.bookTickets();
	}

}
