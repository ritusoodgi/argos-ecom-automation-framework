package com.learning.mavenit.autmation_lab_POM;

import autmation_lab_POM.Utility.Driver_Factory;
import com.learning.mavenit.AutomationCcucumber.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;

import java.util.Random;

public class Hooks extends Driver_Factory {

    @Before
    public void browserSetup() {

        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".privacy-prompt-footer")).click();
    }

    @After
    public void browserQuit() {
        driver.quit();
    }
    public void sleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int randomNumberGenerator(int size) // to get the size of products
    {
        Random random = new Random();
        return random.nextInt(size - 1);
    }

}