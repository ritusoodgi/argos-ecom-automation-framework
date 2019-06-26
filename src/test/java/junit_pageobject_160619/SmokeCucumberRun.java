package junit_pageobject_160619;

import junit_pageobject_160619.pageobject.HomePage;
import junit_pageobject_160619.pageobject.ResultPage;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.everyItem;

public class SmokeCucumberRun extends Hooks {
    HomePage homePage = new HomePage();
    ResultPage resultPage = new ResultPage();

    @Test
    public void searchTest(){
        homePage.doSearch("nike");
        homePage.searchAResult("nike");
    }
    @Test
    public void reviewTest() {
        homePage.doSearch("nike");
        resultPage.selectARating("3or more");
        List<Double> actualRating = resultPage.collectCustomerRating();
        assertThat(actualRating, everyItem(Matchers.greaterThanOrEqualTo(3.0)));
    }

    @Test
    public void priceTest() {
        homePage.doSearch("nike");
        resultPage.selectAPrice("£15 - £20");
        System.out.println("HomePage CucumberRun Passed");
        List<Double> actualList = resultPage.selectedCustomerPrice();
        assertThat(actualList, everyItem(Matchers.greaterThanOrEqualTo(15.0)));
        assertThat(actualList, everyItem(Matchers.lessThanOrEqualTo(20.0)));
        System.out.println("every item is less than 20 and more than 15");
    }

    @Test
    public void basketTest(){
        homePage.doSearch("nike");
        String expectedValueOfClickedProduct=resultPage.selectAProduct();
        System.out.println(expectedValueOfClickedProduct);
        List<String>actualProductInBasket=resultPage.basketTest();
    }

}
