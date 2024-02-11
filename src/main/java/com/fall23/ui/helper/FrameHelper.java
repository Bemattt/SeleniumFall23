package com.fall23.ui.helper;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameHelper {

    public WebDriver driver;
    private WebDriverWait wait;

    public FrameHelper(WebDriver driver){  //вот эту часть нужно понять подробнее
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public FrameHelper swithToFrame(WebElement element){
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    public FrameHelper switchToParentFrame(){
        driver.switchTo().parentFrame();
        return this;
    }

    public FrameHelper switchByIndex(int index){
        driver.switchTo().frame(index);
        return this;
    }

}
