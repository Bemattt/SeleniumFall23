import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WindowHelper;
import com.fall23.ui.pages.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextBoxTest {

    WebDriver driver;
    TextBoxPage textBoxPage;

    @BeforeClass
    void setUpDriver(){
         driver = Driver.getDriver();
         textBoxPage = new TextBoxPage();
    }

    @Test
    void fillUpTheFormPositiveTest() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        textBoxPage.fillUpFullName("John Doe")
                .fillUpEmail("John@gmail.com")
                .fillUpCurrentAddress("Sovet 23")
                .fillUpPermanentAddress("Mira123")
                .clickSubmitBtn();
    }

    @Test
    void test213() throws InterruptedException {


        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tabButton"));
        for (int i = 0; i < 6; i++) {
            newTab.click();
            Thread.sleep(1500);
        }
        WindowHelper windowHelper = new WindowHelper();
        windowHelper.switchToParentWithChildClose();


    }

}
