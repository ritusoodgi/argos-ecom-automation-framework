package cucumber_framework_180619.pageobject;

import cucumber_framework_180619.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class ResultPage extends DriverHelper {
    @FindBy(css = ".search-title__term")
    private WebElement mySearchResult;

    public String searchHeaderName() {
        return mySearchResult.getText();
    }

    /**
     * old metthod of calling locators without using page factory
     * public String searchHeaderName() {
     * //String header = driver.findElement(By.cssSelector(".search-title__term")).getText();
     * // return header;
     * //below is the other way to return the string without storing in a variable
     * // OR without memory allocation
     * return driver.findElement(By.cssSelector(".search-title__term")).getText();
     * }
     * public void actualStarRating(String customerRating) {
     * String customerEnteredRating=customerRating;
     * List<WebElement> ratingWebElements = driver.findElements(By.cssSelector(".ac-facet__filters--rating .ac-facet__label"));
     * applyImpWait();
     * for (WebElement ratingWebElement:ratingWebElements) {
     * if (ratingWebElement.getText().equalsIgnoreCase(customerRating)) {
     * ratingWebElement.click();
     * break;
     * }
     * }
     * }
     **/
    @FindBy(css = ".ac-facet__filters--rating .ac-facet__label")
    List<WebElement> actuallyStarRatings;

    public void actualStarRating(String customerRating) {
        for (WebElement actuallyStarRating : actuallyStarRatings) {
            if (actuallyStarRating.getText().equalsIgnoreCase(customerRating)) {
                applyImpWait();
                actuallyStarRating.click();
                break;
            }

        }

    }
    @FindBy(css = ".ac-product-card__rating")
    private List<WebElement> ratingForAllProducts;
    @FindBy(css = "data-star-rating")
    private WebElement ratingForAllProduct;

    public List<Double> collectCustomerRating() {
        List<Double> ratingCollection=new ArrayList<>();

        /**List<WebElement> ratingOfAllProducts = driver.findElements(By.cssSelector(".ac-product-card__rating"));
        above line swapped with below code using page Factory concept
         @FindBy(css = ".ac-product-card__rating")
         private List<WebElement> ratingForAllProducts;
**/
         for (WebElement ratingOfAllProduct : ratingForAllProducts)
         {
             String attribute = ratingOfAllProduct.getAttribute(String.valueOf(ratingForAllProduct));
             double ratingcollection= parseDouble(String.valueOf(ratingOfAllProduct));
            ratingCollection.add(ratingcollection);
         //  double ratingInDouble= Double.parseDouble(dataInString);
           // ratingCollection.add(ratingInDouble);
        }
        return ratingCollection;

    }
}
//    ResultPage(css=".ac-star-rating__empty-stars") private List<WebElement>collectCustomerRatings ;
//        public List<Double> collectCustomerRating ()
//        {    //List<Double> ratingCollection=new ArrayList<>();
//            List<WebElement> starRatingWebElements = driver.findElements(By.cssSelector(".ac-star-rating__empty-stars"));
//            for (WebElement starRatingWebElement : starRatingWebElements) {
//              String ratingInString  =starRatingWebElement.getAttribute("data-star-rating");
//              double ratingInDouble=Double.parseDouble(ratingInString);
//              ratingCollection.add(ratingInDouble);
//            }
//            return ratingCollection;
//        }
