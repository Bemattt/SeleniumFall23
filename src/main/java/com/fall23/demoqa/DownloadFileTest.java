package com.fall23.demoqa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DownloadFileTest extends BaseTest {

    @Test
    void downloadTest() throws InterruptedException {

        WebDriverManager.openTheSite("https://demoqa.com/upload-download");

        driver.findElement(By.id("uploadedFilePath")).sendKeys("C:fakepath README.txt");
        Thread.sleep(5000);

 }
}
