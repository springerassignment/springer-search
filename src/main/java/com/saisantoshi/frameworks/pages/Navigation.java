package com.saisantoshi.frameworks.pages;

import org.openqa.selenium.WebDriver;

public class Navigation extends Page{

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public <T extends Page> T goTo(Class<T> clazz, final String url ) {
        driver.get(url);
        return initElements(clazz);
    }

}
