package junit_pageobject_160619.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SwitchBrowser {
    public static WebDriver driver;

    public void browserSetUpChoice(String myChoiceBrowser, String url) {

        switch (myChoiceBrowser) {
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

        }driver.get(url);
    }
}
