package com.fall23.ui.pages;

import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {

    public TextBoxPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameInput;

    @FindBy(id = "userEmail")
    public WebElement fullEmailInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public TextBoxPage fillUpFullName(String fullName){
        webElementHelper.sendKeys(fullNameInput,fullName);
        return this;
    }
    public TextBoxPage fillUpEmail(String email){
        webElementHelper.sendKeys(fullEmailInput,email);
        return this;
    }

    public TextBoxPage fillUpCurrentAddress(String currentAddress){
        webElementHelper.sendKeys(currentAddressInput,currentAddress);
        return this;
    }
    public TextBoxPage fillUpPermanentAddress(String permanentAddress) {
        webElementHelper.sendKeys(permanentAddressInput, permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmitBtn() {
        webElementHelper.scrollToElement(submitBtn)
                        .click(submitBtn);
        return this;
    }
}
