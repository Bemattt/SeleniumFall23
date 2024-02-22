import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WebElementHelper;
import com.fall23.ui.pages.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
                .clickBtnDownloads();
        WebElementHelper webElementHelper = new WebElementHelper();
        try {
            webElementHelper.waitForBtnToBeClickAble(checkBoxPage.homeBtnClick);
            checkBoxPage.clickHome();
        } catch (TimeoutException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
            System.out.println("Элемент не стал кликабельным в течение заданного времени.");
        }
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        assertEquals(actualMessage, "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");
      Thread.sleep(7000);


    }

    }
