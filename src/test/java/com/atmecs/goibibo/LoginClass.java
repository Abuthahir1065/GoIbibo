package com.atmecs.goibibo;

import org.testng.annotations.Test;

import browser.SetUp;
import pageActions.GoIbiboLoginAction;

public class LoginClass extends SetUp {

	@Test(priority = 1)
	public void loginTravels() throws InterruptedException {
		GoIbiboLoginAction login = new GoIbiboLoginAction();
		login.login();
	}

}
