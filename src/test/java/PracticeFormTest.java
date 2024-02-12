import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.BrowserManager;
import com.fall23.ui.pages.PracticeFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PracticeFormTest {
    @Test
    void demo1123(){
        BrowserManager browserManager = new BrowserManager(Driver.getDriver());
        browserManager.openByNavigate("https://demoqa.com/automation-practice-form");

        PracticeFormPage practiceFormPage = new PracticeFormPage();
        practiceFormPage.selectDateMonthYear("2 February 2000");


    }
}
