import com.beust.ah.A;
import com.fall23.data.JavaFaker;
import com.fall23.entity.Employee;
import com.fall23.ui.drivers.Driver;
import com.fall23.ui.pages.WebTablePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.fall23.entity.Employee.getEmployeesFromTable;

public class EmployeesTableTest {

    @Test
    void test123(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/webtables");
        Employee randomEmployee = JavaFaker.createNewEmployeeWithFakeData();
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.fillUpTheForm(randomEmployee);
        List<Employee> employees = getEmployeesFromTable(driver);
        employees.forEach(System.out::println);

        // TODO verify all employees data
    }
}