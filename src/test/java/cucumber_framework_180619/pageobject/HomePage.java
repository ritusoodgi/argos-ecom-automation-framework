package cucumber_framework_180619.pageobject;

import cucumber_framework_180619.driver.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Java logics will be here.
public class HomePage extends DriverHelper {
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static String mySearchItem;
    @FindBy(id = "searchTerm")
    private WebElement searchBox;
    @FindBy(css = "button[type='submit']")
    private WebElement magnifierGlass;

    public void doSearch(String searchItem) {
        mySearchItem = searchItem;
        searchBox.sendKeys(searchItem);
        magnifierGlass.click();
    }
}

/**
 * public void doSearch(String searchItem) {
 * expectedSearchPrroduct=searchItem;
 * driver.findElement(By.id("searchTerm")).sendKeys(searchItem, Keys.ENTER);
 * //in page Factory we declare above line like below
 * <p>
 * }
 **/

