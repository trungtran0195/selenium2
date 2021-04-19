package com.logigear.driver.browser.firefox;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.manager.BaseDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
	
public class RemoteFirefoxDriver extends BaseDriver {

	public RemoteFirefoxDriver(DriverProperty property) {
		super(property);
	}

	@Override
	public void createWebDriver() {
		FirefoxOptions ops = new FirefoxOptions();
		
		ops.addArguments(property.getArguments());
		ops.merge(property.getCapabilities());
		
		webDriver = new RemoteWebDriver(property.getRemoteUrl(), ops);
	}
}
