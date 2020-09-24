package pageActions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import browser.SetUp;
import constant.Constant;
import helper.HelperClass;
import reader.PropertyReader;

public class GoIbiboBookAction extends SetUp {
	Properties Location_path;
	Properties Data_path;

	public void bookTickets() throws InterruptedException {
		Location_path = PropertyReader.readProperty(Constant.LOCATOR_FILE_PATH);
		Data_path = PropertyReader.readProperty(Constant.DATA_FILE_PATH);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HelperClass.selectElementById(driver, Location_path.getProperty("RoundTrip_Id"));
		HelperClass.enterElement(driver, Location_path.getProperty("FromXpath"), Data_path.getProperty("From"));
		HelperClass.enterElement(driver, Location_path.getProperty("ToXpath"), Data_path.getProperty("To"));
		HelperClass.ElementSendKeys(driver, Location_path.getProperty("XpathDepart"),
				Data_path.getProperty("Departure"));
		HelperClass.ElementSendKeys(driver, Location_path.getProperty("XpathReturn"), Data_path.getProperty("Return"));
		HelperClass.elementClick(driver, Location_path.getProperty("TravellerXpath"));
		HelperClass.elementClick(driver, Location_path.getProperty("QuantityXpath"));
		HelperClass.selectFromDropDown(driver, Location_path.getProperty("TravelSelectXpath"),
				Data_path.getProperty("value"));
		HelperClass.elementClick(driver, Location_path.getProperty("SearchXpath"));

	}
}