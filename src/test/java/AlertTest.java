import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.AlertHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertTest {

    @Test
    void demo1234(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/alerts");

        AlertHelper alertHelper = new AlertHelper();
//        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
//        confirmButton.click();
//        alertHelper.acceptAlert();

//        WebElement acceptAlertBtn = driver.findElement(By.id("alertButton"));
//        acceptAlertBtn.click();
//        alertHelper.acceptAlert();

//        WebElement timeAlertBtn = driver.findElement(By.id("timerAlertButton"));
//        timeAlertBtn.click();
//        alertHelper.dismissAlert();

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();
        alertHelper.sendKeysAlert("Bema");



    }
}

