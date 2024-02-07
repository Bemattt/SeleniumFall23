package com.fall23.ui.helper;

import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class alertHelper {

    private WebDriver driver;

    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public void acceptAlert(){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        if (!isAlertPresent()){
            return;
        }
        getAlert().accept();
    }

    public void dismissAlert(){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        getAlert().dismiss();
    }

    public void sendKeysAlert(String txt){
        getAlert().sendKeys(txt);
        acceptAlert();
    }

    public boolean isAlertPresent(){
        try {
            Driver.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e){
            e.printStackTrace();
            return false;
        }
    }




}
