package google.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.cartPage;
import pom.demoHomePage;
import pom.searchResults;
import utility.seleniumActions;
import utility.environmentUrls;
import java.util.Hashtable;
import java.util.Locale;

public class testExample {
    /*
        Main variables such as:
        browser
        environment
        some properties or even the data file.
     */

    String browser = "chrome";
    String environment = "PROD";


    private final seleniumActions selFrame = new seleniumActions();
    private final demoHomePage demoHP = new demoHomePage();
    private final environmentUrls envUrl = new environmentUrls();
    private final searchResults searchResults = new searchResults();
    private final cartPage cart = new cartPage();


    private WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        Hashtable<String, String> urlDictionary = envUrl.get_environment_variables();
        String url = urlDictionary.get(environment);

        driver = selFrame.openBrowser(browser);
        selFrame.maximizeBrowser(driver);
        selFrame.navigateToUrl(driver, url);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Test ended");
        //selFrame.closeAllBrowsers(driver);
    }

    @Test
    public void addProductToCart() {
        demoHP.validateLogoIsPresent(driver);
        demoHP.inputTextOnSearchBox(driver, "shirts");
        demoHP.clickOnSearchButton(driver);

        searchResults.validateSearchSiteLoadedProperly(driver);
        String validation = searchResults.getFirstProductText(driver);
        assert(validation.toLowerCase(Locale.ROOT).contains("shirt"));
        searchResults.hoverMouseOnProduct(driver);
        searchResults.clickOnAddToCart(driver);
        searchResults.validateCartPopUpIsDisplayed(driver);
        searchResults.clickProceedToCheckout(driver);


        validation = cart.getSiteTitle(driver);
        assert(validation.toLowerCase(Locale.ROOT).contains(
                "SHOPPING-CART SUMMARY".toLowerCase(Locale.ROOT)));
        cart.validateCartLoadedProperly(driver);
        cart.validateItemIsDisplayedOnCart(driver);
        cart.proceedToCheckout(driver);
    }
}
