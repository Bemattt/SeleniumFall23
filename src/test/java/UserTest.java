import com.fall23.entity.User;
import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.BrowserManager;
import com.fall23.ui.helper.WebElementHelper;
import com.fall23.ui.pages.UsersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    WebDriver driver;
    UsersPage usersPage;
    User user;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        usersPage = new UsersPage();
    }

    @Test(description = "Sign in to browser and choose the Add User field")
    void openBrowserAndLogIn() throws InterruptedException {
        BrowserManager browserManager = new BrowserManager(Driver.getDriver());
        browserManager.openByNavigate("https://app.talentlms.com/login");
        usersPage.domainBtn.sendKeys("aizirekfall23");
        usersPage.loginBtn.sendKeys("Aizirek98");
        usersPage.passwordBtn.sendKeys("7878@Aizi");
        usersPage.inputLoginBtn.click();
        usersPage.adminDashBoardBtn.click();
        Thread.sleep(1000);

        WebElementHelper webElementHelper = new WebElementHelper();

        webElementHelper.click(usersPage.homeAddUserBtn);

        usersPage
                .fillUpUserWithFakerData()
                .selectUserType()
                .selectTimeZone()
                .selectLanguage()
                .clickOnAddUserSubmitBtn();
    }
}

