package com.saisantoshi.frameworks;

import com.saisantoshi.frameworks.pages.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class SearchBehaviour {

    @Test
    public void shouldBeAbleToSearchWithFreeTextAndSeeResults() {

        String text = "Design and Implementation";

        //given
        searchPage = navigation.goTo(SearchPage.class, SPRINGER_HOME);

        //when
        searchResultsPage = searchPage.searchFor(text);

        //then [Please note that this being tested on static test data, the number of results matching a given search
        // term should be known to us ahead of time]
        assertThat(searchResultsPage.getResultsHeaderText(), is(String.format("760,989 Result(s) for '%s'", text)));

    }

    @Test
    public void defaultResultsSortOrderShouldBeRelevance() {

        String text = "Design and Implementation";

        //given
        searchPage = navigation.goTo(SearchPage.class, SPRINGER_HOME);

        //when
        searchResultsPage = searchPage.searchFor(text);

        //then
        assertThat(searchResultsPage.getDefaultSortOrder(), is("relevance"));

    }

    @Test
    public void shouldBeAbleToClearSearchToDefaultSettings() {

        String text = "A Brief History of Time";

        //given
        searchPage = navigation.goTo(SearchPage.class, SPRINGER_HOME);

        //when
        searchResultsPage = searchPage.searchFor(text);
        searchResultsPage = searchPage.clearSearch();


        //then [Please note that this being tested on static test data, the number of results matching a given search
        // term should be known to us ahead of time]
        assertThat(searchResultsPage.getResultsHeaderText(), is("10,660,007 Result(s)"));

    }

    @Test
    public void shouldBeAbleToSeeSearchHelp() {

        //given
        searchPage = navigation.goTo(SearchPage.class, SPRINGER_HOME);

        //when
        searchHelpPage = searchPage.openSearchHelp();

        //then
        assertThat(searchHelpPage.getSearchHelpHeaderText(), is("Search Tips"));

    }

    @Test
    public void shouldBeAbleToSeeAdvancedSearch() {

        //given
        searchPage = navigation.goTo(SearchPage.class, SPRINGER_HOME);

        //when
        advancedSearchPage = searchPage.openAdvancedSearch();

        //then
        assertThat(advancedSearchPage.getAdvancedSearchHeaderText(), is("Advanced Search"));

    }

    @Test
    public void shouldBeAbleToDoAdvancedSearch() {

        //given
        searchPage = navigation.goTo(SearchPage.class, SPRINGER_HOME);

        //when
        advancedSearchPage = searchPage.openAdvancedSearch();
        searchResultsPage = advancedSearchPage.inputIntoTitleContains("Mental Health Care").andSubmit();

        //then [Please note that this being tested on static test data, the number of results matching a given search
        // term should be known to us ahead of time]
        assertThat(searchResultsPage.getResultsHeaderText(), is("456 Result(s)"));

    }


    private static final String SPRINGER_HOME = "http://link.springer.com";

    private static Navigation navigation;
    private static SearchPage searchPage;
    private static SearchResultsPage searchResultsPage;
    private static AdvancedSearchPage advancedSearchPage;
    private static SearchHelpPage searchHelpPage;


    private static final WebDriver driver = new FirefoxDriver();

    static {
        navigation = new Navigation(driver);
    }

}
