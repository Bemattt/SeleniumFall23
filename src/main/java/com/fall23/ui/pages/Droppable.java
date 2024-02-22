package com.fall23.ui.pages;

import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Droppable {
    WebDriver driver;
    WebElementHelper webElementHelper = new WebElementHelper();

    public Droppable(WebDriver driver) {
        this.driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "draggable")
    public WebElement dragBtn;

    @FindBy(id = "droppable")
    public WebElement dropBtn;

    @FindBy(id = "droppableExample-tab-accept")
    public WebElement clickAccept;

    @FindBy(id = "acceptable")
    public WebElement acceptableBtn;

    @FindBy(id = "notAcceptable")
    public WebElement notAcceptableBtn;

   public Droppable simple(WebElement dragBtn, WebElement dropBtn) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragBtn, dropBtn).build().perform();
        return this;
    }

    public Droppable accept(WebElement acceptableBtn, WebElement dropBtn) {
        webElementHelper
                .click(clickAccept)
                .scrollToElement(notAcceptableBtn);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(acceptableBtn, dropBtn).build().perform();

        if (notAcceptableBtn.isDisplayed()) {
            System.out.println("Drop was successful.");
        } else {
            System.out.println("Drop was not successful.");
        }
        return this;
    }
}
