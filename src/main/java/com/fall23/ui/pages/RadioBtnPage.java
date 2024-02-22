package com.fall23.ui.pages;

import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioBtnPage {

    public RadioBtnPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//label[@for=\"yesRadio\"]")
    public WebElement yesBtn;

    @FindBy(xpath = "//label[@for=\"impressiveRadio\"]")
    public WebElement impressiveBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public RadioBtnPage clickYesBtn(){
        webElementHelper.click(yesBtn);
        return this;
    }

    public RadioBtnPage clickImpressiveBtn(){
        webElementHelper.click(impressiveBtn);
        return this;
    }
}

