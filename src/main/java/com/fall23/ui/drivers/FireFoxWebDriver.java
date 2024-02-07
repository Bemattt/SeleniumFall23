package com.fall23.ui.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxWebDriver {

    public static WebDriver loadFireFoxDriver(){
        System.setProperty("webdriver.firefox.driver","src/main/resources/Drivers/geckodriver 13");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }


    //create method to load firefox web driver
}
