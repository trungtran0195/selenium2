package com.logigear.common;

import com.logigear.data.Constants;
import com.logigear.driver.DriverProperty;
import com.logigear.driver.manager.Driver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class TestBase {

    @Parameters({"browser", "autoLogBug", "platform"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String browser, boolean autoLogBug, String platform, Method method, ITestContext context) {
        context.setAttribute("autoLogBug", autoLogBug);
        Driver.config(Constants.BROWSER_SETTING_FILE, platform, browser, method.getName());
        DriverProperty currentProperty = Driver.getCurrentProperty();
        currentProperty.setBrowserPath(currentProperty.getBrowserPath());
        Driver.initDriver();
        Driver.navigate(Constants.RAIL_WAY_BROWSER);
        Driver.setWaitForAjax(false);
        Driver.setTimeOut(Constants.DEFAULT_TIME);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(ITestResult result) {
        System.out.println("Clean up");
        Driver.quit();
    }
}
