package com.logigear.driver.browser.chrome;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.manager.BaseDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteChromeDriver extends BaseDriver {

	public RemoteChromeDriver(DriverProperty property) {
		super(property);
	}

	@Override
	public void createWebDriver() {
		ChromeOptions ops = new ChromeOptions();

		ops.addArguments(property.getArguments());
		ops.merge(property.getCapabilities());

		webDriver = new RemoteWebDriver(property.getRemoteUrl(), ops);
	}
}
