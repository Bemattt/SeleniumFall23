
import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.BrowserManager;
import com.fall23.ui.helper.WebElementHelper;
import com.fall23.ui.pages.UsersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class UserTest {

    WebDriver driver;
    UsersPage usersPage;

    @BeforeClass
    void setUpDriver() {
        driver = Driver.getDriver();
        usersPage = new UsersPage();
    }

    @Test(description = "Sign in to browser and choose the Add User field")
    void addUserTest() throws InterruptedException {
        BrowserManager browserManager = new BrowserManager(Driver.getDriver());
        browserManager.openByNavigate("https://app.talentlms.com/login");
        usersPage.domainBtn.sendKeys("fall2023selenium");
        usersPage.loginBtn.sendKeys("Bema2000");
        usersPage.passwordBtn.sendKeys("Bema@2000");
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
                .clickOnExcludefromEmailsCheckbox()
                .clickOnAddUserSubmitBtn();

        String actualAddUserMessage = usersPage.addUserSuccessMessage.getText();
        assertEquals(actualAddUserMessage, "Success! Do you want to add another user?");
    }

    @Test(description = "click on empty fields")
    void requiredFieldsMessagesTest() throws InterruptedException {
        BrowserManager browserManager = new BrowserManager(Driver.getDriver());
        browserManager.openByNavigate("https://app.talentlms.com/login");
        usersPage.domainBtn.sendKeys("fall2023selenium");
        usersPage.loginBtn.sendKeys("Bema2000");
        usersPage.passwordBtn.sendKeys("Bema@2000");
        usersPage.inputLoginBtn.click();
        usersPage.adminDashBoardBtn.click();
        Thread.sleep(1000);

        WebElementHelper webElementHelper = new WebElementHelper();
        webElementHelper.click(usersPage.homeAddUserBtn);

        usersPage.clickOnAddUserSubmitBtn();

        String actualNameIsRequiredMessage = usersPage.nameIsRequiredMessage.getText();
        assertEquals(actualNameIsRequiredMessage, "'First name' is required");

        String actualLastNameIsRequiredMessage = usersPage.lastNameIsRequiredMessage.getText();
        assertEquals(actualLastNameIsRequiredMessage, "'Last name' is required");

        String actualUserNameIsRequiredMessage = usersPage.userNameMessage.getText();
        assertEquals(actualUserNameIsRequiredMessage, "'Username' is required");

        String actualEmailIsRequiredMessage = usersPage.emailMessage.getText();
        assertEquals(actualEmailIsRequiredMessage, "'Email address' is required");
    }
}

