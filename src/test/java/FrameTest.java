import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest {
    @Test
    void frameTest(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        FrameHelper frameHelper = new FrameHelper(driver);
        WebElement frame1Id = driver.findElement(By.id("frame1"));
        frameHelper.swithToFrame(frame1Id);

        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    }
}
