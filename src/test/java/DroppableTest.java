import com.fall23.ui.drivers.Driver;
import com.fall23.ui.pages.Droppable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.fall23.demoqa.WebDriverManager.driver;

public class DroppableTest {
    WebDriver driver;
    Droppable droppable;

    @BeforeClass
    void setUpDriver() {
        driver = Driver.getDriver();
        droppable = new Droppable(driver);
    }

    @Test
    void testDragAndDrop() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        droppable.simple(droppable.dragBtn, droppable.dropBtn)
                .accept(droppable.acceptableBtn, droppable.dropBtn);
        Thread.sleep(1000);
        droppable.accept(droppable.notAcceptableBtn, droppable.dropBtn);
        Thread.sleep(1000);
    }
}
