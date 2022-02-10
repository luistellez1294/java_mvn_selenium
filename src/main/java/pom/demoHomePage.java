package pom;

import org.openqa.selenium.WebDriver;
import utility.seleniumActions;
import utility.commonMethods;

import java.util.Hashtable;

public class demoHomePage extends seleniumActions{
    //Creating constructors for class
    public demoHomePage(WebDriver driver) {
        super(driver);
        setValidationElements();
        setInputTextElements();
        setClickableElements();
    }

    public demoHomePage() {
        setValidationElements();
        setInputTextElements();
        setClickableElements();
    }



    //Creating common object to access dictionaries dynamically
    commonMethods common = new commonMethods();

    Hashtable<String, String> validationElements = new Hashtable<>();
    Hashtable<String, String> inputTextElements = new Hashtable<>();
    Hashtable<String, String> clickableElements = new Hashtable<>();


/*
    Declaring dictionary for elements by type on Web for their ease of management
    Setters and getters for the dictionary, in an organized way.


 */

    public void setValidationElements() {
        validationElements.put("pageLogo", "xpath://img[@class='logo img-responsive']");
        validationElements.put("shop-phone", "class:shop-phone");
    }

    public void setClickableElements() {
        clickableElements.put("searchButton", "name:submit_search");
        clickableElements.put("contactUs", "class:login");
        clickableElements.put("signIn", "id:contact-link");
    }

    public void setInputTextElements() {
        inputTextElements.put("searchBox", "id:search_query_top");
    }

    private Hashtable<String, String> getValidationElements(){
        return validationElements;
    }

    private Hashtable<String, String> getInputTextElements(){
        inputTextElements.put("searchBox", "id:search_query_top");
        return inputTextElements;
    }

    private Hashtable <String, String> getClickableElements() {
        return clickableElements;
    }

/*
    Creating the methods we will use on home page.


 */


    public void validateLogoIsPresent(WebDriver driver){
        String element = common.getFromDictionary(getValidationElements(), "pageLogo");
        waitUntilElementIsVisible(driver, element, 15);
    }

    public void inputTextOnSearchBox(WebDriver driver, String text) {
        String element = common.getFromDictionary(getInputTextElements(), "searchBox");

        waitUntilElementIsVisible(driver, element, 15);
        clearElement(driver, element);
        inputTextIntoElement(driver, element, text);
    }

    public void clickOnContactUs(WebDriver driver) {
        String element = common.getFromDictionary(getClickableElements(), "contactUs");

        waitUntilElementIsVisible(driver, element, 30);
        clickElement(driver, element);
    }

    public void clickOnSearchButton(WebDriver driver) {
        String element = common.getFromDictionary(getClickableElements(), "searchButton");

        waitUntilElementIsVisible(driver, element, 30);
        clickElement(driver, element);
    }
}