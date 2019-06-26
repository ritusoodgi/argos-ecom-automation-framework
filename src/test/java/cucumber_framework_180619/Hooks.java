package cucumber_framework_180619;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber_framework_180619.driver.DriverHelper;
import org.openqa.selenium.By;

import static cucumber_framework_180619.driver.DriverHelper.driver;

//In hooks we are just performing actions ONLY
public class Hooks {
    DriverHelper driverHelper =new DriverHelper();

    @Before
    public void setup()
    {
        driverHelper.browserSetUp("Chrome");
        driverHelper.getURL("https://www.argos.co.uk/");
        driverHelper.maxBrowser();
        driverHelper.applyImpWait();
        driverHelper.privacyFooter();
    }

//    @After
//    public void closeBrowser()
//    {
//        driverHelper.quitBrowser();
//    }
}
