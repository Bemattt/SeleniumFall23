import com.fall23.ui.data.JavaFaker;
import com.fall23.ui.drivers.Driver;
import com.fall23.ui.entity.Employee;
import com.fall23.ui.pages.WebTablePage;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.fall23.ui.entity.Employee.getEmployeesFromTable;

public class EmployeesTableTest {

    @Test
    @Feature("Demoqa webTable") // ok
    @AllureId("123")// no
    @Description("Verify all employee data in webTable")// ok
    @Epic("WebTable") // ok
    @Flaky//не стабильный код // depends on situation and on functionality
    @Issue("can not save the data") // no
    @Link("https://demoqa.com/webtables")// no
    @Owner("Nuta")// ok
    @Severity(SeverityLevel.CRITICAL)// ok
    @Story("TL-001") // ok
    @TmsLink("")//ссылка на тест кейс // no
    @Tag("Smoke") // ok
    void test1234() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/webtables");

        Employee randomEmployee = JavaFaker.createNewEmployeeWithFakeData();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.fillUpTheForm(randomEmployee);
        Thread.sleep(7000);

        List<Employee> employees = getEmployeesFromTable(driver);
        employees.forEach(System.out::println);

        int totalSalaryAmount = employees.stream()
                .mapToInt(Employee::getSalary).sum();

        int total = 0;
        for (Employee employee : employees){
            total += employee.getSalary();
        }

        System.out.println(totalSalaryAmount);
        System.out.println(total + "total");
    }
}