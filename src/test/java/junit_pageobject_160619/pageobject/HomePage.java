package junit_pageobject_160619.pageobject;

import junit_pageobject_160619.Hooks;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends Hooks {
    public void doSearch(String item) {
        driver.findElement(By.id("searchTerm")).sendKeys(item, ENTER);
        //driver.findElement(By.className("_2mKaC")).click();
    }

    public void searchAResult(String myExpectedValue) {
        String actualSearchValue = driver.findElement(By.cssSelector(".search-title__term")).getText();
        assertThat(actualSearchValue, is(equalToIgnoringCase(myExpectedValue)));
        System.out.println("HomePage assertion is passed & is same customer have searched for");
    }
}
