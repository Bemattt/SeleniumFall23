package com.fall23.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLogin {
    public WebDriver driver;

    @BeforeClass
    void allInOne() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test(description = "Login with valid username and valid password")
    void loginWithValidUsernameAndValidPasswordTest() {

        String actualLoginText = driver.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);

        String username = "Admin";
        String password = "admin123";

        WebElement usernameInputField = driver.findElement(By.name("username"));
        WebElement passwordInputField = driver.findElement(By.name("password"));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualDashboardText = driver.findElement(By.tagName("h6")).getText();
        String expectedDashboardText = "Dashboard";
        Assert.assertEquals(actualDashboardText, expectedDashboardText);
    }

    @Test(description = "Login with invalid username and invalid password")
    void loginWithInvalidUsernameAndInvalidPasswordTest() {

        String actualLoginText = driver.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);

        String invalidUsername = "InvAdmin";
        String invalidPassword = "InvAdmin123";

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        usernameInput.sendKeys(invalidUsername);
        passwordInput.sendKeys(invalidPassword);

        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualErrorMessage = driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


    }

    @Test(description = "Login with valid username and invalid password")
    void loginWithValidUsernameAndInvalidPasswordTest() {

        String actualLoginText = driver.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);

        String validUsername = "Admin";
        String invalidPassword = "InvAdmin123";

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        usernameInput.sendKeys(validUsername);
        passwordInput.sendKeys(invalidPassword);

        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualErrorMessage = driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(description = "Forgot your password? - Button")
    public void forgotYourPassword() {
        WebElement forgotPasswordBtn = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPasswordBtn.click();
        String name = "John";

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(name);

        WebElement resetPassword = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        resetPassword.click();


    }
}




//    //@AfterTest
//    public void closeBrowser(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.close();
//    }
