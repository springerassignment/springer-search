package com.saisantoshi.frameworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends Page {

    @FindBy(how = How.ID_OR_NAME, using = "query")
    @CacheLookup
    private WebElement searchInputField;

    @FindBy(how = How.ID_OR_NAME, using = "search")
    @CacheLookup
    private WebElement submitSearch;

    @FindBy(how = How.ID_OR_NAME, using = "global-search-new")
    @CacheLookup
    private WebElement newSearch;

    @FindBy(how = How.ID_OR_NAME, using = "search-options")
    @CacheLookup
    private WebElement searchOptions;

    @FindBy(how = How.ID_OR_NAME, using = "advanced-search-link")
    @CacheLookup
    private WebElement advancedSearch;

    @FindBy(how = How.ID_OR_NAME, using = "search-help-link")
    @CacheLookup
    private WebElement searchHelpLink;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private SearchPage input(final String searchText ) {
        this.searchInputField.sendKeys(searchText);
        return this;
    }

    private SearchResultsPage andSubmit() {
        searchInputField.submit();
        return initElements(SearchResultsPage.class);
    }

    private SearchPage openSearchOptions() {
        searchOptions.click();
        return this;
    }

    public SearchResultsPage searchFor( final String searchText ) {
        return input(searchText).andSubmit();
    }

    public SearchResultsPage clearSearch() {
        newSearch.click();
        return initElements(SearchResultsPage.class);
    }

    public AdvancedSearchPage openAdvancedSearch() {
        openSearchOptions();
        advancedSearch.click();
        return initElements(AdvancedSearchPage.class);
    }

    public SearchHelpPage openSearchHelp() {
        openSearchOptions();
        searchHelpLink.click();
        return initElements(SearchHelpPage.class);
    }

}
