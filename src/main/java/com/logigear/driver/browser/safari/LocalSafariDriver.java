package com.logigear.driver.browser.safari;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.manager.BaseDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocalSafariDriver extends BaseDriver {

	public LocalSafariDriver(DriverProperty property) {
		super(property);
	}

	@Override
	public void createWebDriver() {
		webDriver = new SafariDriver();
	}
}
