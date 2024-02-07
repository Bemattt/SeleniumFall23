package com.fall23.demoqa.mouseInteractions;

import com.fall23.demoqa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.demoqa.WebDriverManager.openTheSite;
import static org.testng.Assert.assertEquals;

public class CheckBox extends BaseTest {

    @Test
    void homeBtn() throws InterruptedException {
        openTheSite("https://demoqa.com/checkbox");

        WebElement homeClick = driver.findElement(By.cssSelector(".rct-collapse-btn"));
        homeClick.click();
        WebElement desktopClickBtn = driver.findElement(By.cssSelector(".rct-icon-expand-close"));
        desktopClickBtn.click();
        WebElement checkBtn = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > span > label > span.rct-checkbox > svg"));
        checkBtn.click();
        String actualMessage = driver.findElement(By.cssSelector("#result")).getText();
        assertEquals(actualMessage, "You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands");
        WebElement documentsBtn = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > label > span.rct-checkbox > svg"));
        documentsBtn.click();
        WebElement downloadsBtn = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > label > span.rct-checkbox > svg"));
        downloadsBtn.click();

        String actualDesktop = driver.findElement(By.xpath("//span[text()='Desktop']")).getText();
        assertEquals(actualDesktop, "Desktop");
        String actualNotes = driver.findElement(By.xpath("//span[text()='Notes']")).getText();
        assertEquals(actualNotes, "Notes");
        String actualCommands = driver.findElement(By.xpath("//span[text()='Commands']")).getText();
        assertEquals(actualCommands, "Commands");
        WebElement DocumentsBtn = driver.findElement(By.xpath("//label[@for='tree-node-documents']"));
        DocumentsBtn.click();
        String actualDocumentsResult = driver.findElement(By.xpath("//span[text()='Documents']")).getText();
        assertEquals(actualDocumentsResult, "Documents");
        String actualDownloadsResult = driver.findElement(By.xpath("//span[text()='Downloads']")).getText();
        assertEquals(actualDownloadsResult, "Downloads");
        WebElement selectedBtn = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        selectedBtn.click();
        selectedBtn.click();
        homeClick.click();
        Thread.sleep(3000);
    }
}
