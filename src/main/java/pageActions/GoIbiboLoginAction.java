package pageActions;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import browser.SetUp;
import constant.Constant;
import helper.HelperClass;
import reader.PropertyReader;

public class GoIbiboLoginAction extends SetUp {
	Properties Location_path, Data_path;

	public void login() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Location_path = PropertyReader.readProperty(Constant.LOCATOR_FILE_PATH);
		Data_path = PropertyReader.readProperty(Constant.DATA_FILE_PATH);

		HelperClass.elementClick(driver, Location_path.getProperty("XpathSignIn"));

		driver.switchTo().frame("authiframe");
		HelperClass.elementClick(driver, Location_path.getProperty("XpathfbSignIn"));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				HelperClass.ElementSendKeys(driver, Location_path.getProperty("XpathEmail"),
						Data_path.getProperty("Email"));
				HelperClass.ElementSendKeys(driver, Location_path.getProperty("Xpathpassword"),
						Data_path.getProperty("Password"));
				HelperClass.elementClick(driver, Location_path.getProperty("emailLoginXpath"));

				driver.close();

			}

		}
		driver.switchTo().window(parent);

	}
}
