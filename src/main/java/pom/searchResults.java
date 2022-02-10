package pom;

import org.openqa.selenium.WebDriver;
import utility.seleniumActions;
import utility.commonMethods;

import java.util.Hashtable;
import java.util.Locale;

public class searchResults extends seleniumActions{
    public searchResults(WebDriver driver){
        super(driver);
        setClickableElements();
        setHoverElements();
        setValidationElements();
    }

    public searchResults() {
        setClickableElements();
        setHoverElements();
        setValidationElements();
    }

    commonMethods common = new commonMethods();


    Hashtable<String, String> validationElements = new Hashtable<>();
    Hashtable<String, String> clickableElements = new Hashtable<>();
    Hashtable<String, String> hoverElements = new Hashtable<>();


    public void setValidationElements(){
        validationElements.put("resultsFound", "class:heading-counter");
        validationElements.put("firstItemText", "xpath:(//*[@class= 'product-name'])[10]");
        validationElements.put("iconOk", "class:icon-ok");
    }

    public void setHoverElements(){
        hoverElements.put("firstImage", "xpath:(//img[@class='replace-2x img-responsive'])[9]");
    }

    public void setClickableElements(){
        clickableElements.put("addToCart", "xpath://span[contains(text(), 'Add to cart')]");
        clickableElements.put("goToCart", "link:View my shopping cart");
        clickableElements.put("proceedToCheckout", "xpath://span[contains(text() , 'Proceed')]");
    }

    private Hashtable<String, String> getValidationElements(){
        return validationElements;
    }

    private Hashtable<String, String> getHoverElements() {
        return hoverElements;
    }

    private Hashtable<String, String> getClickableElements(){
        return clickableElements;
    }


    /*
        Methods for searchResults Page.
     */


    public void validateSearchSiteLoadedProperly(WebDriver driver) {
        String element = common.getFromDictionary(getValidationElements(), "resultsFound");

        waitUntilElementIsVisible(driver, element, 10);
        String text = getTextFromElement(driver, element);

        assert(text.toLowerCase(Locale.ROOT).contains("been found"));
    }

    public String getFirstProductText(WebDriver driver) {
        String element = common.getFromDictionary(getValidationElements(), "firstItemText");

        waitUntilElementIsVisible(driver, element, 25);
        return getTextFromElement(driver, element);
    }

    public void clickOnAddToCart(WebDriver driver) {
        String element = common.getFromDictionary(getClickableElements(), "addToCart");

        waitUntilElementIsVisible(driver, element, 5);
        clickElement(driver, element);
    }

    public void clickProceedToCheckout(WebDriver driver) {
        String element = common.getFromDictionary(getClickableElements(), "proceedToCheckout");

        waitUntilElementIsVisible(driver, element, 7);
        waitUntilElementIsInteractable(driver, element, 10);
        clickElement(driver, element);
    }

    public void validateCartPopUpIsDisplayed(WebDriver driver){
        String element = common.getFromDictionary(getValidationElements(), "iconOk");

        waitUntilElementIsVisible(driver, element, 10);
    }

    public void hoverMouseOnProduct(WebDriver driver) {
        String element = common.getFromDictionary(getHoverElements(), "firstImage");

        hoverElement(driver, element);
    }

}
