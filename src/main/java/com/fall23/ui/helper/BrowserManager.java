package com.fall23.ui.helper;

import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BrowserManager {

    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
    }

    public void openByNavigate(final String URL){
        driver.navigate().to(URL);
    }

    public void openByGet(final String URL){
        driver.get(URL);
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void goForward(){
        driver.navigate().forward();
    }

    public void refreshThePage(){
        driver.navigate().refresh();
    }


    public BrowserManager swithToFrame(WebElement element){
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BrowserManager switchToParentFrame(){
        driver.switchTo().parentFrame();
        return this;
    }

    public BrowserManager switchByIndex(int index){
        driver.switchTo().frame(index);
        return this;
    }

    public static Set<String> getWindowHandles() {
        return Driver.getDriver().getWindowHandles();
    }
    public void switchToWindow(int index) {
        Set<String> handles = getWindowHandles();
        List<String> windowsId = new LinkedList<>(handles);

        if (index < 0 || index >= windowsId.size()) {
            throw new IllegalArgumentException("You provided a wrong index: " + index);
        }

        Driver.getDriver().switchTo().window(windowsId.get(index));
    }
    public void switchToParent() {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        Driver.getDriver().switchTo().window(windowsId.get(0));
    }

    public void switchToParentWithChildClose() {
        switchToParent();

        LinkedList<String> windowsId = new LinkedList<>(
                getWindowHandles()
        );

        for (int i = 1; i < windowsId.size(); i++){
            Driver.getDriver().switchTo().window(windowsId.get(i));
            Driver.getDriver().close();
        }
        switchToParent();
    }
}
