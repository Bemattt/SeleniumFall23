package com.fall23.ui.pages;

import com.fall23.entity.User;
import com.fall23.ui.data.JavaFaker;
import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.DropDownHelper;
import com.fall23.ui.helper.WebElementHelper;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class UsersPage {

    WebDriver driver = Driver.getDriver();
    WebElementHelper webElementHelper = new WebElementHelper();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    User randomUser = JavaFaker.createNewUserWithFakerData();

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//input[@name='domain'])[1]")
    public WebElement domainBtn;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBtn;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement inputLoginBtn;

    @FindBy(xpath = "//b[text()='Administrator dashboard']")
    public WebElement adminDashBoardBtn;

    @FindBy(xpath = "(//div[@class='hidden-phone']/child::a)[1]")
    public WebElement homeAddUserBtn;

    @FindBy(xpath = "(//a[@class='btn btn-primary'])[3]")
    public WebElement addUserBtn;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstnameInput;

    @FindBy(xpath = "//input[@name='surname']")
    public WebElement lastnameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement bioInput;

    @FindBy(xpath = "(//span[@class=\"select2-arrow\"])[1]")
    public WebElement userTypesSelectBtn;

    @FindBy(xpath = "(//span[@class=\"select2-chosen\"])[2]")
    public WebElement timeZoneSelectBtn;

    @FindBy(xpath = "//span[contains(text(),'English')]")
    public WebElement languageSelectInput;

    @FindBy(xpath = "//input[@id=\"status\"]")
    public WebElement activeCheckbox;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement deActivateAtCheckbox;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement excluseFromEmailsCheckbox;

    @FindBy(xpath = "//input[@name=\"submit_personal_details\"]")
    public WebElement addUserSubmitBtn;

    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelAddUserSubmitBtn;

    public UsersPage fillUpUserWithFakerData() {
        webElementHelper
                .sendKeys(firstnameInput, randomUser.getFirstname())
                .sendKeys(lastnameInput, randomUser.getLastname())
                .sendKeys(emailInput, randomUser.getEmailAddress())
                .sendKeys(usernameInput, randomUser.getUsername())
                .sendKeys(passwordInput, randomUser.getPassword())
                .sendKeys(bioInput, randomUser.getBio());
        return this;
    }

    public UsersPage selectUserType() throws InterruptedException {
        Thread.sleep(3000);
        webElementHelper.click(userTypesSelectBtn);
        List<WebElement> userTypeDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = new Random().nextInt(userTypeDropDown.size());
        userTypeDropDown.get(randomIndex).click();
        Thread.sleep(3000);
        return this;
    }

    public UsersPage selectTimeZone() throws InterruptedException {
        webElementHelper.click(timeZoneSelectBtn);
        Thread.sleep(3000);
        List<WebElement> timeZoneDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = new Random().nextInt(timeZoneDropDown.size());
        timeZoneDropDown.get(randomIndex).click();
        Thread.sleep(3000);
        return this;

    }

    public UsersPage selectLanguage() throws InterruptedException {
        webElementHelper.click(languageSelectInput);
        List<WebElement> languageDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = new Random().nextInt(languageDropDown.size());
        webElementHelper.waitForBtnToBeClickAble(languageSelectInput);
        languageDropDown.get(randomIndex).click();
        Thread.sleep(3000);
        return this;
    }

    public UsersPage clickOnAddUserSubmitBtn() {
        webElementHelper.scrollToElement(activeCheckbox)
                .click(activeCheckbox);
        return this;
    }
}


