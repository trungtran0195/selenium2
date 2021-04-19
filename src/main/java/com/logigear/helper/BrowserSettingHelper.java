package com.logigear.helper;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.DriverType;
import com.logigear.driver.RunningMode;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

import java.io.FileReader;

public class BrowserSettingHelper {

    public static DriverProperty getDriverProperty(String file, String sectionName, String testCaseName) {
        DriverProperty property = new DriverProperty();

        try {
            Ini ini = new Ini(new FileReader(file));
            Section section = ini.get(sectionName);
            if (section == null) {
                throw new Exception(String.format("Cannot find '%s' in file '%s'", sectionName, file));
            }
            String mode = section.get("mode");
            String driverType = section.get("driver");
            String browserName = driverType.toLowerCase();
            String driverVersion = section.get("driverVersion");
            String remoteUrl = section.get("remoteUrl");
            String capabilities = section.get("capabilities");
            String args = section.get("arguments");
            String browserPath = section.get("browserPath");

            property.setDriverVersion(driverVersion);
            property.setDriverType(convertStringToDriverType(driverType));
            property.setBrowserName(browserName);
            property.setRemoteUrl(remoteUrl);
            property.setMode(convertStringToRunningMode(mode));
            property.setCapabilities(addTestCaseName(capabilities, testCaseName));
            property.setArguments(args);
            property.setBrowserPath(browserPath);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return property;
    }

    private static String addTestCaseName(String capabilities, String testCaseName) {
        if (capabilities == null)
            return null;

        StringBuilder buf = new StringBuilder(capabilities);
        buf.insert(1, "\"name\":\"" + testCaseName + "\",");
        return buf.toString();
    }

    private static RunningMode convertStringToRunningMode(String mode) throws Exception {
        try {
            return RunningMode.valueOf(mode);
        } catch (Exception e) {
            throw new Exception(String.format("Don't allow the '%s'. Please use %s for your configuration", mode,
                    RunningMode.asString()));
        }
    }

    private static DriverType convertStringToDriverType(String type) throws Exception {
        try {
            return DriverType.valueOf(type);
        } catch (Exception e) {
            throw new Exception(String.format("Don't allow the '%s'. Please use %s for your configuration", type,
                    DriverType.asString()));
        }
    }

}
