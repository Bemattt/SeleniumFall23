import com.fall23.ui.drivers.Driver;
import com.fall23.ui.pages.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.pages.CheckBoxPage;

import static org.testng.Assert.assertEquals;

public class CheckBoxTest {

        WebDriver driver;
        CheckBoxPage checkBoxPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        checkBoxPage = new CheckBoxPage();
    }

    @Test
    void clickBtnPositive() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");
        checkBoxPage.clickBtnHome()
                .clickBtnDesktop()
                .clickBtnDocuments()
                .clickBtnDownloads()
                .clickBtnHome();

    }

    }
