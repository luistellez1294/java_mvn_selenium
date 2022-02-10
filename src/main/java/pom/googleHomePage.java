package pom;

import org.openqa.selenium.WebDriver;
import utility.seleniumActions;

public class googleHomePage extends seleniumActions{

    private String searchBox = "xpath://input[@class='gLFyf gsfi']";
    private String googleLogo = "class:lnXdpd";
    private String gmailLink = "xpath://a[contains(@href,'mail/&')]";

    public googleHomePage(WebDriver driver) {
        super(driver);
    }

    public googleHomePage() {

    }

    public String getGmailLinkText(WebDriver driver) {
        waitUntilElementIsVisible(driver, gmailLink, 2);
        return getTextFromElement(driver, gmailLink);
    }

    public void validateGoogleLogoIsPresent(WebDriver driver){
        waitUntilElementIsVisible(driver, googleLogo, 15);
    }

    public void inputTextOnGoogleSearchBox(WebDriver driver, String text) {
        waitUntilElementIsVisible(driver, searchBox, 15);
        clearElement(driver, searchBox);
        inputTextIntoElement(driver, searchBox, text);
    }
}