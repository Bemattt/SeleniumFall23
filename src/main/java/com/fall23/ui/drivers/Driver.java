package com.fall23.ui.drivers;

import com.fall23.ui.config.configReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (configReader.getValue("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver =FireFoxWebDriver.loadFireFoxDriver();
                    //TODO add firefox
                    break;
                case "safari":
                    driver = SafariWebDriver.loadSafariDriver();
                    break;
                //TODO add all drivers
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }

        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if(driver!=null){
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e){
            System.out.println("Error while closing driver");
        }
    }
}
