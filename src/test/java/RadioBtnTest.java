import com.fall23.ui.drivers.Driver;
import com.fall23.ui.pages.RadioBtnPage;
import com.fall23.ui.pages.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RadioBtnTest {

    WebDriver driver;
    RadioBtnPage radioBtnPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        radioBtnPage = new RadioBtnPage();
    }

    @Test
    void clickTheRadioBtn() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");
        radioBtnPage.yesBtn.click();
        String actualYesMessage = driver.findElement(
                By.xpath("//p[@class=\"mt-3\"]")).getText();
        assertEquals(actualYesMessage, "You have selected Yes");
        radioBtnPage.impressiveBtn.click();
        String actualImpressiveMessage = driver.findElement(
                By.xpath("//p[@class=\"mt-3\"]")).getText();
        assertEquals(actualImpressiveMessage, "You have selected Impressive");
        String actualNoMessage = driver.findElement(
                By.xpath("//label[@for=\"noRadio\"]")).getText();
        assertEquals(actualNoMessage, "No");

        Thread.sleep(5000);
    }
}
