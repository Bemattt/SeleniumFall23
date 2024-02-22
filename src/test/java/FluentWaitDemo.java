import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentWaitDemo {

    @Test
    void test1(){

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
}
