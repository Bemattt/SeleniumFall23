package com.fall23.ui.helper;

import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WindowHelper {

    private WebDriver driver;

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

//    public static void main(String[] args) throws InterruptedException {
//        Driver.getDriver().get("https://demoqa.com/browser-windows");
//        WebElement newTab = Driver.getDriver().findElement(By.id("tabButton"));
//        for (int i = 0; i < 3; i++) {
//            newTab.click();
//            Thread.sleep(4000);
//        }
//        switchToWindow(1);
//        Thread.sleep(6000);
//        Driver.getDriver().quit();
//    }

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