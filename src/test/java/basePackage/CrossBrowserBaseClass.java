package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;
import utilityPackage.BrowserUtility;

public class CrossBrowserBaseClass
{

    public BrowserUtility browserUtil;
    public WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void openDesiredBrowser(String browser)
    {
        browserUtil = new BrowserUtility();
        browserUtil.openBrowser(browser);
        browserUtil.openUrl("https://www.saucedemo.com/");

        browserUtil.waitForElements(5);

        driver = browserUtil.getDriver();
    }

    @AfterClass
    public void terminateBrowser()
    {
        browserUtil.closeBrowser();
    }
}
