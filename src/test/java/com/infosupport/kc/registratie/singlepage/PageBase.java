package com.infosupport.kc.registratie.singlepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {



    protected WebDriver webDriver;

    protected PageBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
