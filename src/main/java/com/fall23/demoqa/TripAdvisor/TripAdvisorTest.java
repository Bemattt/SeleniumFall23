package com.fall23.demoqa.TripAdvisor;

import com.fall23.demoqa.BaseTest;
import com.fall23.demoqa.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TripAdvisorTest extends BaseTest {

    @Test
    void Test1() {
        WebDriverManager.openTheSite("https://www.tripadvisor.ru");

        WebElement whereYouGo = driver.findElement(By.xpath("//div[@class=\"biGQs _P fiohW hEDHV izyXJ\"]"));
        String actualResult = driver.findElement(By.xpath("//div[@class=\"biGQs _P fiohW hEDHV izyXJ\"]")).getText();
        String expectedResult = "Куда Вы едете?";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    void Test2() throws InterruptedException {
        WebDriverManager.openTheSite("https://www.tripadvisor.ru");

        WebElement searchBtn = driver.findElement(By.xpath("//input[@type=\"search\"]"));
//        String actualSearch = driver.findElement(By.xpath("//*[@id=\"lithium-root\"]/main/div[4]/div/div/div[2]/div/form/div/div/input")).getText();
//        String expectedSearch = "Куда сходить, чем заняться, где остановиться...";
        searchBtn.click();
//        Assert.assertEquals(actualSearch,expectedSearch);
        searchBtn.sendKeys("Бишкек");
        Thread.sleep(6000);
    }
    @Test
    void Test3() throws InterruptedException {
        WebDriverManager.openTheSite("https://www.youtube.com");

        WebElement searchBtn1 = driver.findElement(By.xpath("//input[@id='search']"));
        searchBtn1.click();
//        searchBtn1.sendKeys("Мирбек Атабеков");
//        WebElement searchBtn2 = driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]"));
//        searchBtn2.click();
        searchBtn1.sendKeys("Selena Gomez");
        WebElement searchBtn2 = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchBtn2.click();
        WebElement searchVideo =driver.findElement(By.xpath("//img[@src='https://i.ytimg.com/vi/WcIcVapfqXw/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg=" +
                "=&rs=AOn4CLBBuuqTw5qsauxyy1t8Yfx-kKFDyA']"));
        searchVideo.click();
        Thread.sleep(100000);
    }

    @Test
    void Test4() throws InterruptedException {
        WebDriverManager.openTheSite("https://www.youtube.com");

        String actualSearch = driver.findElement(By.xpath("//yt-formatted-string[@class=\"title style-scope ytd-guide-entry-renderer\"]")).getText();
        String expectedSearch = "Home";
        Assert.assertEquals(actualSearch,expectedSearch);
        Thread.sleep(6000);
    }
}


