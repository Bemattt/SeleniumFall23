import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.BrowserManager;
import com.fall23.ui.helper.WebElementHelper;
import com.fall23.ui.pages.StudentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.fall23.demoqa.WebDriverManager.driver;

public class StudentRegistrationFormTest {
    @Test
    void demoTest123() throws InterruptedException {
        BrowserManager browserManager = new BrowserManager(Driver.getDriver());
        browserManager.openByNavigate("https://demoqa.com/automation-practice-form");

        StudentPage studentPage = new StudentPage(driver);


        WebElement genderMale = studentPage.maleBtn;
        WebElement genderFemale = studentPage.femaleBtn;
        WebElement genderOther = studentPage.otherBtn;
        List<WebElement> genderElements = Arrays.asList(genderMale, genderFemale, genderOther);

        List<String> selectSubjects = Arrays.asList("Bi", "Ch", "Comp", "Eng", "Eco","His", "Ma", "Ph", "So");

        WebElement sports = studentPage.sportBtn;
        WebElement reading = studentPage.readingBtn;
        WebElement music = studentPage.musicBtn;
        List<WebElement> randomHobbies = Arrays.asList(sports, reading, music);

        Thread.sleep(3000);

        studentPage.fillUpTheRegistrationForm()
                .chooseRandomGender(genderElements)
                .randomDateOfBirth()
                .randomMobileNumber()
                .randomDateOfBirth()
                .selectSubject(selectSubjects)
                .selectRandomHobbies(randomHobbies)
                .inputCurrentAddress()
                .selectStateAndCity()
                .submitBtn();
    }
}
