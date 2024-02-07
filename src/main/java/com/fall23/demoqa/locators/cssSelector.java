package com.fall23.demoqa.locators;

import com.fall23.demoqa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.demoqa.WebDriverManager.openTheSite;

public class cssSelector extends BaseTest {


    @Test
    void demo1234() throws InterruptedException {
        openTheSite("https://demoqa.com/text-box");

        WebElement userNameBtn = driver.findElement(By.cssSelector("#userName"));
        userNameBtn.click();
        userNameBtn.sendKeys("John Duo");
        WebElement emailNameBtn = driver.findElement(By.cssSelector("#userEmail"));
        emailNameBtn.click();
        emailNameBtn.sendKeys("johnduo@gmail.com");
        Thread.sleep(6000);

    }
}
