package com.saisantoshi.frameworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage extends Page {

    @FindBy(how = How.ID_OR_NAME, using = "kb-nav--main")
    @CacheLookup
    private WebElement searchResultsPanel;

    @FindBy(how = How.CLASS_NAME, using = "number-of-search-results-and-search-terms")
    @CacheLookup
    private WebElement searchResultsHeader;

    @FindBy(how = How.CLASS_NAME, using = ".functions-bar.functions-bar-top")
    @CacheLookup
    private WebElement searchFunctionsBar;

    @FindBy(how = How.ID_OR_NAME, using = "results-list")
    @CacheLookup
    private WebElement searchResultsList;

    @FindBy(how = How.ID_OR_NAME, using = "sort-results")
    @CacheLookup
    private WebElement searchResultsSortBy;

    @FindBy(how = How.CLASS_NAME, using = "page-number")
    @CacheLookup
    private WebElement searchResultsCurrentPage;


    @FindBy(how = How.ID, using = "results-only-access-checkbox")
    @CacheLookup
    private WebElement includePreviewOnlyCheckbox;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getDefaultSortOrder() {
        return new Select(searchResultsSortBy).getFirstSelectedOption().getText().toLowerCase();
    }

    public String getResultsHeaderText() {
        return searchResultsHeader.getText();
    }

    public int getResultsCount() {
        return Integer.parseInt(searchResultsHeader.getText().split(" Result(s) for ")[0]);
    }

    public int getResultsCurrentPage() {
        return Integer.parseInt(searchResultsCurrentPage.getAttribute("value"));
    }

    public void selectIncludePreviewOnlyCheckbox() {
        includePreviewOnlyCheckbox.click();
    }
}
