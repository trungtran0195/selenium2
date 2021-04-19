package com.logigear.driver;

import com.logigear.helper.JsonHelper;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DriverProperty {

    private URL remoteUrl;
    private String platform;
    private String browserName;
    private DriverType driverType;
    private String driverVersion;
    private String browserPath;
    private RunningMode mode;
    private DesiredCapabilities capabilities;
    private List<String> arguments;

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = JsonHelper.convertJsonToCapabilities(capabilities);
    }

    public RunningMode getMode() {
        return mode;
    }

    public void setMode(RunningMode mode) {
        this.mode = mode;
    }

    public boolean isRemoteMode() {
        if (getMode() != null && getMode() == RunningMode.Remote)
            return true;
        return false;
    }

    public URL getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) throws MalformedURLException {
        if (remoteUrl != null)
            this.remoteUrl = new URL(remoteUrl);
    }

    public DriverType getDriverType() {
        return driverType;
    }

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }

    /**
     * @return the arguments
     */
    public List<String> getArguments() {
        return arguments;
    }

    /**
     * @param arguments
     *            the arguments to set
     */
    public void setArguments(String arguments) {
        this.arguments = JsonHelper.convertJsonToArguments(arguments);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserPath() {
        return browserPath;
    }

    public void setBrowserPath(String browserPath) {
        this.browserPath = browserPath;
    }

    public String getDriverVersion() {
        return driverVersion;
    }

    public void setDriverVersion(String driverVersion) {
        this.driverVersion = driverVersion;
    }

}
