package autmation_lab_POM.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver_Factory {
   public static WebDriver driver;
    public void OpenBrowser(String b, String url) {

        switch (b) {

            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case "Safari":
                driver = new SafariDriver();
                break;

            default:
               driver=new FirefoxDriver();

        }
        driver.get(url);
        driver.getTitle();
    }
}
