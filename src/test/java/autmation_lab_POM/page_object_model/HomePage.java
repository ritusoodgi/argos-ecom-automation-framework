package com.learning.mavenit.autmation_lab_POM.page_object_model;

import com.learning.mavenit.autmation_lab_POM.Hooks;
import org.openqa.selenium.By;

public class HomePage extends Hooks {

    public void doSearch(String searchItem)
    {
        driver.findElement(By.id("searchTerm")).sendKeys(searchItem );
        driver.findElement(By.className("_2mKaC")).click();
    }
}
