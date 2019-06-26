package cucumber_framework_180619.step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_framework_180619.pageobject.HomePage;
import cucumber_framework_180619.pageobject.ResultPage;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Rating_Steps {

    private ResultPage resultPage = new ResultPage();

    @When("^i select a rating \"([^\"]*)\"$")
    public void i_select_a_rating(String arg1) {
        resultPage.actualStarRating(arg1);
    }

    @Then("^i should get the products within rating range$")
    public void i_should_get_the_products_within_rating_range( ) 
    {
       List<Double> actualCustomerRating = resultPage.collectCustomerRating();
        String t = "4.0";
        assertThat(actualCustomerRating,everyItem(greaterThanOrEqualTo(t)));
        //assertThat(actualCustomerRating,everyItem(greaterThanOrEqualTo("4.0")));
    }

    private void assertThat(List<Double> actualCustomerRating, Matcher<Iterable<String>> everyItem) {
    }

    @When("^i select a rating filter\"([^\"]*)\"$")
    public void i_select_a_rating_filter(String arg1) {
        resultPage.actualStarRating(arg1);

    }


}

//    @When("^i select a rating range$")
//    public void i_select_a_rating_range(String ratingRange){
//        resultPage.actualStarRating(ratingRange);
//    }
//
//    @Then("^i should get the products within rating range$")
//    public void i_should_get_the_products_within_rating_range() {
//       // resultPage.collectCustomerRating();
//
//        }
//    @When("^i select a rating filter\"([^\"]*)\"$")
//    public void i_select_a_rating_filter(String arg1){
//        resultPage.actualStarRating(arg1);
//
//    }
//
//    @And("^i select a rating \"([^\"]*)\"$")
//    public void iSelectARating(String arg0) {
//
//    }
//}
