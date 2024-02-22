import com.fall23.ui.drivers.Driver;
import com.fall23.ui.helper.DropDownHelper;
import com.fall23.ui.helper.WebElementHelper;
import com.fall23.ui.pages.SelectMenuPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDemo {
    @Test
    void demo1(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/select-menu");
        SelectMenuPage selectMenuPage = new SelectMenuPage();
        DropDownHelper dropDownHelper = new DropDownHelper();
        dropDownHelper.selectByText(selectMenuPage.oldStyleSelectMenu,"Green");
        WebElementHelper webElementHelper = new WebElementHelper();

        List<String> list = dropDownHelper.getAllDropDownMenu(selectMenuPage.oldStyleSelectMenu);
        list.forEach(System.out::println);

        webElementHelper.sendKeysWithEnter(selectMenuPage.selectValueInput,"Pro");


    }
}
