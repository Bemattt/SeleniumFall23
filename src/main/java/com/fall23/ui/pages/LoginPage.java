package com.fall23.ui.pages;

import com.fall23.demoqa.WebDriverManager;
import com.fall23.ui.drivers.Driver;
import com.fall23.ui.entity.Employee;
import com.fall23.ui.entity.NewUserName;
import com.fall23.ui.helper.AlertHelper;
import com.fall23.ui.helper.WebElementHelper;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    Faker faker = new Faker();

    public LoginPage(WebDriver driver){
        this.driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public LoginPage newUserRegistration() throws InterruptedException {
        WebElementHelper webElementHelper = new WebElementHelper();
        webElementHelper.click(driver.findElement(By.id("newUser")));
        webElementHelper.sendKeys(driver.findElement(By.id("firstname")), faker.name().firstName());
        webElementHelper.sendKeys(driver.findElement(By.id("lastname")), faker.name().lastName());
        webElementHelper.sendKeys(driver.findElement(By.id("userName")), faker.name().username());
        webElementHelper.sendKeys(driver.findElement(By.id("password")), faker.internet().password(8,16,true,true,true));
        WebElement iframe = driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']"));
        driver.switchTo().frame(iframe);
        WebElement clickCaptcha = driver.findElement(By.className("recaptcha-checkbox-border"));
        clickCaptcha.click();
        Thread.sleep(30000);
        driver.switchTo().defaultContent();
        webElementHelper.waitForBtnToBeClickAble(driver.findElement(By.id("register")));
        WebElement clickRegisterBtn = driver.findElement(By.id("register"));
        clickRegisterBtn.click();
        AlertHelper alertHelper = new AlertHelper();
        alertHelper.isAlertPresent();
        alertHelper.acceptAlert();
        webElementHelper.waitForBtnToBeClickAble(driver.findElement(By.id("gotologin")));
        WebElement clickBackToLogin = driver.findElement(By.id("gotologin"));
        clickBackToLogin.click();
        return this;
    }

    public LoginPage loginUser(){
        WebElementHelper webElementHelper = new WebElementHelper();
        webElementHelper.sendKeys(driver.findElement(By.id("userName")),"Bema0202")
                .sendKeys(driver.findElement(By.id("password")),"0202Bema@");
        webElementHelper.click(driver.findElement(By.id("login")));
        webElementHelper.scrollToElement(driver.findElement(By.id("gotoStore")));
        webElementHelper.waitForBtnToBeClickAble(driver.findElement(By.id("gotoStore")));
        WebElement clickBackToLogin = driver.findElement(By.id("gotoStore"));
        clickBackToLogin.click();
        webElementHelper.click(driver.findElement(By.id("see-book-Git Pocket Guide")))
                .scrollToElement(driver.findElement(By.xpath("//button[text()='Add To Your Collection']")))
                .click(driver.findElement(By.xpath("//button[text()='Add To Your Collection']")));
        AlertHelper alertHelper = new AlertHelper();
        alertHelper.isAlertPresent();
        alertHelper.acceptAlert();

        webElementHelper.click(driver.findElement(By.id("addNewRecordButton")))
                .scrollToElement(driver.findElement(By.id("see-book-Speaking JavaScript")))
                .click(driver.findElement(By.id("see-book-Speaking JavaScript")))
                .scrollToElement(driver.findElement(By.xpath("//button[text()='Add To Your Collection']")))
                .click(driver.findElement(By.xpath("//button[text()='Add To Your Collection']")));
        alertHelper.isAlertPresent();
        alertHelper.acceptAlert();
        webElementHelper.click(driver.findElement(By.id("addNewRecordButton")));
        return this;
    }

    public LoginPage goToProfile() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/profile");
//        WebElementHelper webElementHelper = new WebElementHelper();
//        webElementHelper.click(driver.findElement(By.xpath("//li[@class=\"btn btn-light active\"]")));
        return this;
    }
}


