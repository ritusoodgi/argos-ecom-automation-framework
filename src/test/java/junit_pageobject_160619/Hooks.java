package junit_pageobject_160619;

import junit_pageobject_160619.utilities.SwitchBrowser;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hooks extends SwitchBrowser {

    @Before
    public void BrowserSetUp() {
        browserSetUpChoice("FireFox", "https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

//    @After
//    public void closeBrowser() {
//        driver.quit();
//    }
}
