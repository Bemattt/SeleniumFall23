package com.fall23.ui.pages;

import com.fall23.ui.drivers.Driver;
import org.openqa.selenium.support.PageFactory;

public class Buttons {

    public Buttons() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
