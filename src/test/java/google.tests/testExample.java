package google.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.googleHomePage;
import utility.seleniumActions;
import utility.environmentUrls;
import java.util.Hashtable;

public class testExample {

    private seleniumActions selFrame = new seleniumActions();
    private WebDriver driver;
    private googleHomePage googleHP = new googleHomePage(driver);
    private environmentUrls envUrl = new environmentUrls();

    private Hashtable<String, String> urlDictionary = new Hashtable<String, String>();

    @BeforeMethod
    public void setUp()
    {
        selFrame.setDriver(driver);
        driver = new ChromeDriver();
        selFrame.maximizeBrowser(driver);
        urlDictionary = envUrl.get_google_environment_variables();
        String url = urlDictionary.get("UAT");
        selFrame.navigateToUrl(driver, url);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Test Case ended");
        selFrame.closeAllBrowsers(driver);
    }

    @Test
    public void searchBoxTest() {
        googleHP.validateGoogleLogoIsPresent(driver);
        String text = googleHP.getGmailLinkText(driver);
        Assert.assertEquals("Gmail", text);
        googleHP.inputTextOnGoogleSearchBox(driver, "text");
    }
}
