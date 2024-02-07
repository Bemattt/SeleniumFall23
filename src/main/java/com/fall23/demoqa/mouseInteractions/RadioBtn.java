package com.fall23.demoqa.mouseInteractions;

import com.fall23.demoqa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.demoqa.WebDriverManager.openTheSite;
import static org.testng.Assert.assertEquals;

public class RadioBtn extends BaseTest {

    @Test
    void radioBtn() throws InterruptedException {
        openTheSite("https://demoqa.com/radio-button");

        WebElement yesClick = driver.findElement(By.xpath("//label[@for=\"yesRadio\"]"));
        yesClick.click();
        String actualYesMessage = driver.findElement(By.xpath("//p[@class=\"mt-3\"]")).getText();
        assertEquals(actualYesMessage, "You have selected Yes");

        WebElement impressiveClick = driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]"));
        impressiveClick.click();
        String actualImpressiveMessage = driver.findElement(By.xpath("//p[@class=\"mt-3\"]")).getText();
        assertEquals(actualImpressiveMessage, "You have selected Impressive");

        String actualNoMessage = driver.findElement(By.xpath("//label[@for=\"noRadio\"]")).getText();
        assertEquals(actualNoMessage, "No");

        Thread.sleep(5000);
    }
}
