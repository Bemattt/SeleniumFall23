import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FrameTest {
    @Test
    void frameTest(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");

        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    }
}
