package pom;

import com.google.common.collect.HashBasedTable;
import org.openqa.selenium.WebDriver;
import utility.commonMethods;
import utility.seleniumActions;

import java.util.Hashtable;

public class cartPage extends seleniumActions {
    public cartPage(WebDriver driver){
        super(driver);
        setClickableElements();
        setValidationElements();
    }

    public cartPage(){
        setClickableElements();
        setValidationElements();
    }

    //Object to call the get from dictionary.
    commonMethods common = new commonMethods();

    Hashtable<String, String> clickableElements = new Hashtable<>();
    Hashtable<String, String> validationElements = new Hashtable<>();

    public void setClickableElements() {
        clickableElements.put("proceedToCheckout", "xpath:(//span[contains(text(), 'Proceed')])[2]");
    }

    public void setValidationElements() {
        validationElements.put("cartTitle", "id:cart_title");
        validationElements.put("product", "link:Faded Short Sleeve T-shirts");
    }

    public Hashtable<String, String> getClickableElements(){
        return clickableElements;
    }

    public Hashtable<String, String> getValidationElements(){
        return validationElements;
    }





    /*
    Methods for the page navigation

     */

    public void validateCartLoadedProperly(WebDriver driver){
        String element = common.getFromDictionary(getValidationElements(), "cartTitle");
        waitUntilElementIsVisible(driver, element, 10);
    }

    public String getSiteTitle(WebDriver driver) {
        String element = common.getFromDictionary(getValidationElements(), "cartTitle");

        waitUntilElementIsVisible(driver, element, 10);
        return getTextFromElement(driver, element);
    }

    public void validateItemIsDisplayedOnCart(WebDriver driver) {
        String element = common.getFromDictionary(getValidationElements(), "product");

        waitUntilElementIsVisible(driver, element, 10);
    }

    public void proceedToCheckout(WebDriver driver) {
        String element = common.getFromDictionary(getClickableElements(), "proceedToCheckout");

        waitUntilElementIsVisible(driver, element, 5);
        clickElement(driver, element);
    }

}
