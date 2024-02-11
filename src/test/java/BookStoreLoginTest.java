import com.fall23.ui.drivers.Driver;
import com.fall23.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BookStoreLoginTest {

    @Test
    void demoTest123() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.newUserRegistration();
    }

    @Test
    void demoTest1234() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser();
        loginPage.goToProfile();
        Thread.sleep(15000);
    }
}
