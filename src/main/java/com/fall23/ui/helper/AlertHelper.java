package com.fall23.ui.helper;

import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    public Alert getAlert(){

        return Driver.getDriver().switchTo().alert();
    }

    public void acceptAlert(){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        if (!isAlertPresent()){
            return; // остановись (останавливай программу)
        }
        getAlert().accept();

    }

    public AlertHelper dismissAlert(){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        getAlert().dismiss();
        return this;
    }

    public AlertHelper sendKeysAlert(String txt){
        getAlert().sendKeys(txt);
        acceptAlert(); //dismiss();
        return this;
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
