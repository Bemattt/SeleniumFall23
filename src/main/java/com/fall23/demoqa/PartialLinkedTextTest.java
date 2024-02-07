package com.fall23.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.demoqa.WebDriverManager.openTheSite;

public class PartialLinkedTextTest extends BaseTest {

    @Test
    void demo() throws InterruptedException {

        openTheSite("https://demoqa.com/links");

        WebElement unauth = driver.findElement(By.partialLinkText("Unauth"));
        unauth.click();
        Thread.sleep(5000);
    }
}
