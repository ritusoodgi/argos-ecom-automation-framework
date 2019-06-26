package cucumber_framework_180619.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class DriverHelper {

    public static WebDriver driver;
    public DriverHelper() {
        /**initialise the page factory in the constructor method and assign to driver level*/
        PageFactory.initElements(driver, this);
    }
    public void privacyFooter()
    {
        driver.findElement(By.className("privacy-prompt-footer")).click();
    }
    public void browserSetUp(String myBrowser) {

        switch (myBrowser) {
            case "Safari":
                driver = new SafariDriver();
                break;

            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                //WebDriverManager.chromedriver().version(".26").setup
                //method to port to older versions
                break;

            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
    }

    public void getURL(String URL) {
        driver.get(URL);
    }

    public void maxBrowser() {
        driver.manage().window().maximize();

    }

    public void applyImpWait() {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

    public void quitBrowser() {
        driver.quit();
    }

}
