package cucumber_framework_180619.step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_framework_180619.pageobject.HomePage;
import cucumber_framework_180619.pageobject.ResultPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Search_Steps {
    HomePage homePage = new HomePage();
    private ResultPage resultPage = new ResultPage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {

        String currentUrl = homePage.getCurrentUrl();
        assertThat(currentUrl, is(endsWith("co.uk/")));
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void i_search_for_product(String arg1) {
        homePage.doSearch(arg1);
    }

    @Then("^I should get the respective product$")
    public void i_should_get_the_respective_product() {
        String actualSearch = resultPage.searchHeaderName();
        assertThat(actualSearch, is(equalToIgnoringCase(homePage.mySearchItem)));
    }

}
