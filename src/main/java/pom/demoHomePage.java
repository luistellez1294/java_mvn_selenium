package pom;

import org.openqa.selenium.WebDriver;
import utility.seleniumActions;
import utility.commonMethods;

import java.util.Hashtable;

public class googleHomePage extends seleniumActions{

    private commonMethods common;

    Hashtable<String, String> validationElements = new Hashtable<String, String>();

    public void setValidationElements(){
        validationElements.put("searchBox", "xpath://input[@class='gLFyf gsfi']");
    }

    //private String searchBox = "xpath://input[@class='gLFyf gsfi']";
    private String googleLogo = "class:lnXdpd";
    private String gmailLink = "xpath://a[contains(@href,'mail/&')]";

    public googleHomePage(WebDriver driver) {
        super(driver);
        setValidationElements();
    }

    public googleHomePage() {
        setValidationElements();
    }

    public String getGmailLinkText(WebDriver driver) {
        waitUntilElementIsVisible(driver, gmailLink, 2);
        return getTextFromElement(driver, gmailLink);
    }

    public void validateGoogleLogoIsPresent(WebDriver driver){
        waitUntilElementIsVisible(driver, googleLogo, 15);
    }

    public void inputTextOnGoogleSearchBox(WebDriver driver, String text) {
        String element = common.getFromDictionary(validationElements, "searchBox");

        waitUntilElementIsVisible(driver, element, 15);
        clearElement(driver, element);
        inputTextIntoElement(driver, element, text);
    }
}