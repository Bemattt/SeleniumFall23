import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WebElementHelper;
import com.fall23.ui.pages.Buttons;
import com.fall23.ui.pages.RadioBtnPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ButtonsTest {


    WebDriver driver;
    ButtonsTest buttonsTest;

    @BeforeClass
    void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
        driver = Driver.getDriver();
        buttonsTest = new ButtonsTest();
    }

    @Test
    void doubleClickMessage() {
        driver.get("https://demoqa.com/buttons");
        WebElementHelper webElementHelper = new WebElementHelper();
        webElementHelper.doubleClick(driver.findElement(By.xpath("//*[@id=\"doubleClickBtn\"]")));
        String actualDoubleClickMessage = driver.findElement(By.id("doubleClickBtn")).getText();
        assertEquals(actualDoubleClickMessage, "You have done a double click");
    }
}
