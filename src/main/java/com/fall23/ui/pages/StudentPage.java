package com.fall23.ui.pages;

import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.BrowserManager;
import com.fall23.ui.helper.DropDownHelper;
import com.fall23.ui.helper.WebElementHelper;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentPage {


    private WebDriver driver;
    private WebElement subjectsInput;
    Faker faker = new Faker();
    WebElementHelper webElementHelper = new WebElementHelper();
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    DropDownHelper dropDownHelper = new DropDownHelper();

    public StudentPage(WebDriver driver) {
        this.driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    public WebElement maleBtn;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    public WebElement femaleBtn;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    public WebElement otherBtn;

    @FindBy(xpath = ("//*[@id=\"userNumber\"]"))
    public WebElement mobileNumberXpath;

    @FindBy(className = ("react-datepicker__month-select"))
    public WebElement month;

    @FindBy(className = ("react-datepicker__year-select"))
    public WebElement year;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    public WebElement sportBtn;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")
    public WebElement readingBtn;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")
    public WebElement musicBtn;

    @FindBy(xpath = "//*[@id=\"currentAddress\"]")
    public WebElement address;

    @FindBy(xpath = "//*[@id=\"uploadPicture\"]")
    public WebElement chooseFileBtn;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public StudentPage fillUpTheRegistrationForm() {
        WebElementHelper webElementHelper = new WebElementHelper();
        webElementHelper.sendKeys(firstName, faker.name().firstName());
        webElementHelper.sendKeys(lastName, faker.name().lastName());
        webElementHelper.sendKeys(email, faker.internet().emailAddress());
        return this;
    }

    public StudentPage chooseRandomGender(List<WebElement> genderElements) {
        Random random = new Random();
        int index = random.nextInt(genderElements.size());
        genderElements.get(index).click();
        return this;
    }

    public StudentPage randomMobileNumber() {
        String mobileNumber = faker.phoneNumber().subscriberNumber(10);
        mobileNumberXpath.sendKeys(mobileNumber);
        return this;
    }

    public StudentPage randomDateOfBirth() {
        int minYear = 1900;
        int maxYear = 2101;
        int randomYear = faker.random().nextInt(minYear, maxYear);
        LocalDate birthday = LocalDate.of(randomYear, 1, 1).plusDays(faker.random().nextInt(366));
        String dateMonthYear = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH).format(birthday);

        webElementHelper.click(practiceFormPage.datePickerBtn);

        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("react-datepicker__month-select")));
        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("react-datepicker__year-select")));
        dropDownHelper.selectByText(monthDropDown, month).selectByText(yearDropDown, year);

        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[contains(@class," +
                        "'react-datepicker__day') and not(contains" +
                        "(class,'react-datepicker__day--outside-month')) and text() ='" + day + "']")));

        webElementHelper.click(dayElement);
        return this;
    }

    public StudentPage selectSubject(List<String> availableSubjects) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomSubjectIndex = random.nextInt(availableSubjects.size());
            String subject = availableSubjects.get(randomSubjectIndex);

            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(Keys.TAB);
        }
        return this;
    }

    public StudentPage selectRandomHobbies(List<WebElement> hobbies) {
        webElementHelper.scrollToElement(driver.findElement(By.xpath("//*[@id=\"subjects-label\"]")));
        Random random = new Random();
        int randomCount = random.nextInt(hobbies.size() + 1);
        java.util.Collections.shuffle(hobbies);

        for (int i = 0; i < randomCount; i++) {
            WebElement randomElement = hobbies.get(i);
            randomElement.click();
        }
        return this;
    }

    public StudentPage inputCurrentAddress() {
        address.sendKeys(faker.address().fullAddress());
        return this;
    }

    public StudentPage selectRandomPicture() {
        String directoryPath = "/Users/bematumarbekova/Desktop/screen folder";

        try {
            List<Path> files = getFilesInDirectory(directoryPath);
            Path randomImagePath = getRandomFile(files);
            uploadPicture(randomImagePath.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    private List<Path> getFilesInDirectory(String directoryPath) throws Exception {
        Path directory = Paths.get(directoryPath);
        return Files.list(directory).toList();
    }

    private Path getRandomFile(List<Path> files) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(files.size());
        return files.get(randomIndex);
    }

    private void uploadPicture(String filePath) {
        System.out.println("Uploading picture: " + filePath);
        WebElement fileInput = chooseFileBtn;
        fileInput.sendKeys(filePath);
    }

    public StudentPage selectStateAndCity() {
        Map<String, List<String>> stateCityMapping = new HashMap<>();
        stateCityMapping.put("N", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        stateCityMapping.put("U", Arrays.asList("Agra", "Lucknow", "Meerut"));
        stateCityMapping.put("Har", Arrays.asList("Karnal", "Panipat"));
        stateCityMapping.put("Raja", Arrays.asList("Jaipur", "Jaisalmer"));

        List<String> states = Arrays.asList("N", "U", "Har", "Raja");
        int randomState = faker.random().nextInt(states.size());
        String state = states.get(randomState);

        List<String> cities = stateCityMapping.get(state);
        String city = cities.get(faker.random().nextInt(cities.size()));
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.TAB);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.TAB);
        return this;
    }

    public StudentPage submitBtn() {
        webElementHelper.scrollToElement(driver.findElement(By.id("submit")));
        webElementHelper.waitForBtnToBeClickAble(driver.findElement(By.id("submit")));
        submitBtn.click();
        return this;
    }
}











