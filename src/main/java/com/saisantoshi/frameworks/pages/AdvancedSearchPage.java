package com.saisantoshi.frameworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchPage extends Page {

    @FindBy(how = How.ID_OR_NAME, using = "advanced-search")
    @CacheLookup
    private WebElement advancedSearchPanel;

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    private WebElement advancedSearchHeader;

    @FindBy(how = How.ID_OR_NAME, using = "title-is")
    @CacheLookup
    private WebElement titleContainsInputField;

    @FindBy(how = How.ID_OR_NAME, using = "submit-advanced-search")
    @CacheLookup
    private WebElement submit;

    @FindBy(how = How.ID, using = "results-only-access-checkbox")
    @CacheLookup
    private WebElement includePreviewOnlyCheckbox;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public String getAdvancedSearchHeaderText() {
        return advancedSearchHeader.getText();
    }

    public AdvancedSearchPage inputIntoTitleContains( final String text ) {
        titleContainsInputField.sendKeys(text);
        return this;
    }

    public SearchResultsPage andSubmit() {
        submit.click();
        return initElements(SearchResultsPage.class);
    }


    public void selectIncludePreviewOnlyCheckbox() {
        includePreviewOnlyCheckbox.click();
    }
}
