import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WindowsTest {

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
        windowHelper.switchToWindow(0);
        windowHelper.switchToParent();
        windowHelper.switchToParentWithChildClose();


    }

}
