package com.fall23.ui.helper;

import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.fall23.demoqa.WebDriverManager.driver;

public class WebElementHelper {

    private Select select;

    public WebElementHelper waitForBtnToBeClickAble(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementHelper waitForElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementHelper click(WebElement element){
        waitForBtnToBeClickAble(element);
        element.click();
        return this;
    }

    public WebElementHelper sendKeys(WebElement element,String txt){
        waitForElementToBeDisplayed(element);
        element.sendKeys(txt);
        return this;
    }
    public WebElementHelper scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
    public WebElementHelper doubleClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementHelper rightClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        return this;
    }
    public WebElementHelper selectByText(WebElement element,String txt){
        select = new Select(element);
        select.selectByVisibleText(txt);
        return this;
    }

    public WebElementHelper selectByIndex(WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);
        return this;
    }
    public WebElementHelper selectByValue(WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);
        return this;
    }
    public List<String> getAllDropDownMenu(WebElement element){
        select = new Select(element);
        List<WebElement>elementList = select.getOptions();
        List<String> valueList = new LinkedList<>();

        for(WebElement element1 : elementList){
            valueList.add(element1.getText());
        }
        return valueList;
    }
}
