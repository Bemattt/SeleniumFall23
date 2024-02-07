package com.fall23.demoqa.mouseInteractions;

import com.fall23.demoqa.BaseTest;
import com.fall23.demoqa.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdvancedMouseInteractions extends BaseTest {

    @Test
    void doubleClick() throws InterruptedException {
        WebDriverManager.openTheSite("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();

        String actualDoubleClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        assertEquals(actualDoubleClickMessage,"You have done a double click");
        Thread.sleep(5000);
    }

    @Test
    void rightClick() throws InterruptedException {
        WebDriverManager.openTheSite("https://demoqa.com/buttons");

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        String actualContextClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        assertEquals(actualContextClickMessage,"You have done a right click");
        Thread.sleep(5000);
    }
    @Test
    void click() throws InterruptedException {
        WebDriverManager.openTheSite("https://demoqa.com/buttons");


        WebElement clickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickBtn).perform();
        String actualDynamicClick = driver.findElement(By.id("dynamicClickMessage")).getText();
        assertEquals(actualDynamicClick,"You have done a dynamic click");
        Thread.sleep(5000);
    }
}






