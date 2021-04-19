package com.logigear.driver.browser.electron;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.manager.BaseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class LocalElectronDriver extends BaseDriver {

    public LocalElectronDriver(DriverProperty property) {
        super(property);
    }

    @Override
    public void createWebDriver() {
        if (this.property.getDriverVersion() != null && !this.property.getDriverVersion().isEmpty()) {
            WebDriverManager.chromedriver().version(this.property.getDriverVersion()).setup();
        } else {
            WebDriverManager.chromedriver().setup();
        }
        List<String> types = new ArrayList<>();
        types.add("app");
        types.add("webview");
        ChromeOptions ops = new ChromeOptions();
        ops.setCapability("windowTypes", types);
        ops.setBinary(this.property.getBrowserPath());
        ops.addArguments(property.getArguments());
        ops.merge(property.getCapabilities());
        webDriver = new ChromeDriver(ops);
    }
}
