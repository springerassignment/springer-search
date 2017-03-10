package com.saisantoshi.frameworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    protected static WebDriver driver;

    protected Page( final WebDriver driver ) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected  <T extends Page> T initElements(Class<T> clazz) {
        return PageFactory.initElements(driver, clazz);
    }

}
