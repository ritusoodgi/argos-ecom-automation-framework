package junit_pageobject_160619.pageobject;

import junit_pageobject_160619.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends Hooks {
    public void selectARating(String customerRating) {
        //collect web elements for ratings
        List<WebElement> selectRatingOfProducts = driver.findElements(By.cssSelector(".ac-facet__filters--rating .ac-facet__label"));
        //need to find the particular element to click
        for (WebElement selectRatingOfProduct : selectRatingOfProducts) {
            if (selectRatingOfProduct.getText().equalsIgnoreCase(customerRating)) {
                selectRatingOfProduct.click();
                break;
            }
        }
    }

    public List<Double> collectCustomerRating() {
        List<Double> rating = new ArrayList<Double>(); // storing collected rating in an array list of doubles
        // storing all webelements in a variable
        List<WebElement> starRatingWebElements = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement starRatingWebElement : starRatingWebElements) {
            // get attribute() method is used to get the value from DOM
            String collectedRatingInDouble = starRatingWebElement.getAttribute("data-star-rating");
            //System.out.println(collectedRatingInDouble);
            double collectedRating = Double.parseDouble(collectedRatingInDouble);
            //System.out.println(collectedRating);
            rating.add(collectedRating);
            System.out.println(rating);
        }
        return rating;
    }

    public void selectAPrice(String customerSelectedPrice) {
        // collect all the WebElements prices in list
        List<WebElement> selectedPriceOfProducts = driver.findElements(By.cssSelector(".ac-facet__filters--default .ac-facet__label--default"));
        for (WebElement selectedPriceOfProduct : selectedPriceOfProducts) {
            if (selectedPriceOfProduct.getText().equalsIgnoreCase(customerSelectedPrice)) {
                selectedPriceOfProduct.click();
                break;
            }
        }
    }

    public List<Double> selectedCustomerPrice() //Asserting the price which customer selected
    {
        //storing webelements price in list
        List<Double> collectedPrices = new ArrayList<Double>();
        List<WebElement> selectedPriceOfProducts = driver.findElements(By.cssSelector(".ac-product-price__amount"));
        for (WebElement selectedPriceOfProduct : selectedPriceOfProducts) {
            //System.out.println(selectedPriceOfProduct);
            String priceInString = selectedPriceOfProduct.getText().replace("£", "");
            System.out.println(priceInString);
            double priceInDouble = Double.parseDouble(priceInString);
            collectedPrices.add(priceInDouble);
        }
        return collectedPrices;
    }

    //selecting a product by randdom method
    public String selectAProduct() {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector
                (".ac-product-card__name"));
        //collecting size of list of elements-which is an integer
        int productSize = productWebElements.size();
        //calling Helper class to access it's method
        int randomProduct = new Helper().randomNumberGenerator(productSize);
        //getting the product name for random product
        String randomSelectedProduct = productWebElements.get(randomProduct).getText();
        productWebElements.get(randomProduct).click();
        //navigate to trolley
        driver.findElement(By.cssSelector(".add-to-trolley-main .button--full")).sendKeys(Keys.ENTER);
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".xs-row .sm-order-2")).click();
        return randomSelectedProduct;
    }

    public List<String> collectProductNames() {
        List<String> productNames = new ArrayList<String>();
        List<WebElement> listOfProducts = driver.findElements(By.cssSelector("ac-product-card__name"));
        for (WebElement listOfProduct : listOfProducts) {
            productNames.add(listOfProduct.getText());
        }
        return productNames;
    }
    public List<String> basketTest()
    {
        List<String> BasketProductNames=new ArrayList<>();
        List<WebElement> BasketProductWebElements=driver.findElements
                (By.cssSelector(".lgBlock .ProductCard__titleLink__1PgaZ"));
        for (WebElement BasketProductWebElement:BasketProductWebElements) {
            BasketProductNames.add(BasketProductWebElement.getText());
        }return BasketProductNames;
    }
}

//    public void collectProductsNames() {
//        //  List<String> productNames = new ArrayList<String>();
//        // List<WebElement> listOfWebElements = driver.findElements(By.className("ac-product-card__name"));
//        // System.out.println(listOfWebElements);
////        for (WebElement listOfWebElement : listOfWebElements)
////        {
////          productNames.add(listOfWebElement.getText());
////        }
////        System.out.println(productNames);
//        driver.findElement(By.cssSelector(".add-to-trolley-main .button--full")).sendKeys(Keys.ENTER);
//        driver.findElement(By.cssSelector(".add-to-trolley-modal__cta .sm-block")).sendKeys(Keys.ENTER);
//        // return productNames;
//    }
//}

//    public List<String> collectProductNames() {
//        List<String> productList = new ArrayList<String>();
//         List <WebElement> listOfWebElements=driver.findElements(By.className
//                ("ac-product-card__name"));
//        System.out.println("****************");
//        System.out.println(listOfWebElements);
//        for (WebElement listOfWebElement : listOfWebElements) {
//
//            productList.add(listOfWebElement.getText());
//        }
//        return productList;
//    }
//}

//    public void searchAResult(String myExpectedValue) {
//        //get the value and  store it in a variable
//        String actualSearchValue = driver.findElement(By.cssSelector(".search-title__term")).getText();
//        //do assertion on variable
//        //Assert.assertEquals(actualSearchValue,myExpectedValue); //assert by junit
//        assertThat(actualSearchValue, is(Matchers.equalToIgnoringCase(myExpectedValue))); //Matchers assertion
//
//        System.out.println("Yes Expected equals to actual");
//    }