import com.fall23.ui.data.JavaFaker;
import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.WebElementHelper;
import com.fall23.ui.pages.LoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    void demoTest123() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.newUserRegistration();
    }

    @Test
    void demoTest1234(){

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser();

    }
}
