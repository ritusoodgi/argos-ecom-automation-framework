package com.learning.mavenit.autmation_lab_POM.page_object_model;

import com.learning.mavenit.autmation_lab_POM.Hooks;
import com.learning.mavenit.autmation_lab_POM.ResultPage;
import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//locator will be result page
//result page will become smoke
public class SmokeTestSuite extends Hooks
{
    private HomePage homepage = new HomePage();
   private ResultPage locator = new ResultPage();

    @Test
    public void runTest() {
        homepage.doSearch("nike");
        locator.searchAResult("nike");
    }

    @Test
    public void reviewTest()
    {
        homepage.doSearch("nike");
        locator.selectARating("3or more");
        List<Double> actualRating=locator.collectCustomerRating();
        assertThat(actualRating,everyItem(Matchers.greaterThanOrEqualTo(3.0)));
    }
    @Test
    public void priceTest()
    {
        homepage.doSearch("nike");
        locator.selectAPrice("£15 - £20");
        System.out.println("Search Test Passed");
        List<Double> actualList= locator.selectedCustomerPrice();
        assertThat(actualList,everyItem(Matchers.greaterThanOrEqualTo(15.0)));
        assertThat(actualList,everyItem(Matchers.lessThanOrEqualTo(20.0)));
        System.out.println("every item is less than 20 and more than 15");
    }
    @Test
    public void trolleyTest() {
        homepage.doSearch("nike");
        locator.selectAPrice("£15 - £20");
        String productSelection = locator.selectAProducts();
        locator.collectProductsNames();
        List<String> actualProductsInTrolley = locator.collectProductsNames();
        assertThat(actualProductsInTrolley, contains(productSelection));
        String actualProductInTrolley = locator.selectAProducts();
        List<String> allProducts = locator.collectProductNames();
        assertThat(allProducts, contains(actualProductInTrolley));
}
}


