package com.saisantoshi.frameworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchHelpPage extends Page {

    @FindBy(how = How.ID_OR_NAME, using = "content")
    @CacheLookup
    private WebElement searchHelpPanel;

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    private WebElement searchHelpHeader;

    public SearchHelpPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchHelpHeaderText() {
        return searchHelpHeader.getText();
    }

}
