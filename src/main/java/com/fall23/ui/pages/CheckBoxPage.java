package ui.pages;

import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckBoxPage {
    public CheckBoxPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement homeBtn;

    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[2]")
    public WebElement desktopBtn;

    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[3]")
    public WebElement documentsBtn;

    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[4]")
    public WebElement downloadsBtn;



    WebElementHelper webElementHelper = new WebElementHelper();

    public CheckBoxPage clickBtnHome(){
        webElementHelper.click(homeBtn);
        return this;
    }

    public CheckBoxPage clickBtnDesktop(){
        webElementHelper.click(desktopBtn);
        return this;
    }

    public CheckBoxPage clickBtnDocuments(){
        webElementHelper.click(documentsBtn);
        return this;
    }
    public CheckBoxPage clickBtnDownloads(){
        webElementHelper.click(downloadsBtn);
        return this;
    }
}