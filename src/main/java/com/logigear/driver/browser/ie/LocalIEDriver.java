package com.logigear.driver.browser.ie;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.manager.BaseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class LocalIEDriver extends BaseDriver {

	public LocalIEDriver(DriverProperty property) {
		super(property);
	}

	@Override
	public void createWebDriver() {
		WebDriverManager.iedriver().arch32().setup();
		InternetExplorerOptions ops = new InternetExplorerOptions();
		
		ops.merge(property.getCapabilities());
		
		webDriver = new InternetExplorerDriver(ops);
	}
}
