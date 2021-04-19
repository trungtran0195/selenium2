package com.logigear.driver.manager;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Driver extends DriverManager {
    private static Logger logger = Logger.getLogger(Driver.class);

    public static TargetLocator switchTo() {
        return getDriver().switchTo();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public static String getSessionId() {
        String sessionId = null;
        try {
            sessionId = ((RemoteWebDriver) getDriver()).getSessionId().toString();
        } catch (Exception ex) {
            logger.error("An error occurred when getting session Id " + ex.getMessage());
        }
        return sessionId;
    }

    public static void navigate(String url) {
        logger.debug("Navigate to " + url);
        try {
            getDriver().get(url);
        } catch (Exception e) {
            logger.error("An error occurred when nagivating " + e.getMessage());
        }
    }

    public static void maximizeBrowser() {
        try {
            logger.debug("Maximize browser");
            getDriver().manage().window().maximize();
        } catch (Exception e) {
            logger.error("An error occurred when maximizing browser" + e.getMessage());
        }
    }

    public static Object execJavaScript(String script, Object... objs) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, objs);
    }

    public static void waitForAjaxJQueryProcess() {
        logger.debug("Wait for ajax complete");
        WebDriverWait wait = new WebDriverWait(getDriver(), getTimeOut());
        try {
            wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    Boolean ajaxIsComplete = (Boolean) (execJavaScript("return Ext.Ajax.isLoading() == false;"));
                    return ajaxIsComplete;
                }
            });
        } catch (Exception e) {
            logger.error("An error occurred when waitForAjaxJQueryProcess" + e.getMessage());
        }
    }

    public static void waitForWindowNotEqual(final String handle, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(driver -> {
            String current = driver.getWindowHandle();
            System.out.println("Current:" + current);
            System.out.println("handle:" + handle);
            return !current.equals(handle);
        });
    }

    public static void waitForTitleNotEqual(final String title, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(new Function<WebDriver, Boolean>() {
                private String currentTitle = "";

                public Boolean apply(WebDriver driver) {
                    this.currentTitle = driver.getTitle();
                    return this.currentTitle != null && !this.currentTitle.contains(title);
                }
            });
        } catch (Exception e) {
            logger.error("An error occurred when waitForTitleNotEqual process " + e.getMessage());
        }
    }

    public static void close() {
        try {
            logger.debug("Close browser");
            getDriver().close();

        } catch (Exception e) {
            logger.error("An error occurred when closing browser" + e.getMessage());
        }
    }

    public static void quit() {
        try {
            logger.debug("Quit browser");
            getDriver().quit();
            removeKey();
        } catch (Exception e) {
            logger.error("An error occurred when quiting browser" + e.getMessage());
        }
    }

    public static WebDriver getWebDriver() {
        return getDriver();
    }

    public static String captureScreenshot(String filename, String filepath) {
        logger.info("Capture screenshot");
        String path = "";
        try {
            // Taking the screen using TakesScreenshot Class
            File objScreenCaptureFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

            // Storing the image in the local system.
            File dest = new File(filepath + File.separator + filename);
            FileUtils.copyFile(objScreenCaptureFile, dest);
            path = dest.getAbsolutePath();
        } catch (Exception e) {
            logger.error("An error occurred when capturing screen shot: " + e.getMessage());
        }
        return path;
    }

    public static void delay(double timeInSecond) {
        try {
            Thread.sleep((long) (timeInSecond * 1000));
        } catch (Exception e) {
            logger.error("An error occurred when delay: " + e.getMessage());
        }
    }

    public static String captureScreenshotAsBase64() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static List<String> getWindowHandles() {
        return new ArrayList<String>(getDriver().getWindowHandles());
    }

    public static String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public static void switchTo(String windowHandle) {
        getDriver().switchTo().window(windowHandle);
    }

    public static void switchToNewAndCloseOldWindow() {
        List<String> handles = getWindowHandles();
        close();
        switchTo(handles.get(1));
    }

    public static void switchToWindowNotContainsPageSource(String source) {
        List<String> all = getWindowHandles();
        for (int i = 0; i < all.size(); i++) {
            Driver.switchTo(all.get(i));
            if (!Driver.getWebDriver().getPageSource().contains(source)) {
                return;
            }
        }
        throw new RuntimeException("Cannot find any windows that does not contains page source: " + source);
    }

    public static void switchToFirst() {
        switchTo(getWindowHandles().get(0));
    }

    public static void openNewTab() {
        execJavaScript("window.open('about:blank','_blank');");
    }

    public static String getRemoteCapability(String key) {
        return ((RemoteWebDriver) getDriver()).getCapabilities().getCapability(key).toString();
    }
}
