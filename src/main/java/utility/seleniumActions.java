package utility;


import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;


public class seleniumActions {

    public WebDriver driver;

    public seleniumActions(WebDriver driver) {
        this.driver = driver;
    }

    public seleniumActions(){

    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void navigateToUrl(WebDriver driver, String url){
        driver.get(url);
    }

    public WebElement getElement(WebDriver driver, String elementToClick){
        String[] splitString = elementToClick.split(":");
        WebElement element = null;
        String identifier = splitString[0].toLowerCase(Locale.ROOT);
        try {

            if(identifier.equals("id")) {
                element = driver.findElement(By.id(splitString[1]));
            }

            if(identifier.equals("link")) {
                element = driver.findElement(By.linkText(splitString[1]));
            }

            if(identifier.equals("xpath")) {
                element = driver.findElement(By.xpath(splitString[1]));
            }

            if(identifier.equals("class")) {
                element = driver.findElement(By.className(splitString[1]));
            }

            if(identifier.equals("css")) {
                element = driver.findElement(By.cssSelector(splitString[1]));
            }

            if(identifier.equals("partialLink")) {
                element = driver.findElement(By.partialLinkText(splitString[1]));
            }
        }
        catch (ElementNotVisibleException e) {
            System.out.println("Could not get the element because it is not visible");
        }
        return element;
    }

    public void clickElement(WebDriver driver, String elementToClick){
        WebElement element = getElement(driver, elementToClick);
        element.click();
    }

    public void clearElement(WebDriver driver, String elementToClick){
        WebElement element = getElement(driver, elementToClick);
        element.clear();
    }

    public void inputTextIntoElement(WebDriver driver, String elementToEnterText, String textToInput){
        WebElement element = getElement(driver, elementToEnterText);
        element.sendKeys(textToInput);
    }

    public String getTextFromElement(WebDriver driver, String elementToGetText){
        WebElement element = getElement(driver, elementToGetText);
        return element.getText();
    }

    public void closeAllBrowsers(WebDriver driver){
        driver.quit();
    }

    public void maximizeBrowser(WebDriver driver){
        driver.manage().window().maximize();
    }

    public void waitUntilElementIsVisible(WebDriver driver, String elementToWait, int timeToWait){
        WebDriverWait wait;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(timeToWait));

        String[] splitString = elementToWait.split(":");
        String identifier = splitString[0].toLowerCase(Locale.ROOT);

        try {

            if(identifier.equals("id")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.id(splitString[1])
                ));
            }

            if(identifier.equals("link")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.linkText(splitString[1])
                ));
            }

            if(identifier.equals("xpath")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(splitString[1])
                ));
            }

            if(identifier.equals("class")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.className(splitString[1])
                ));
            }

            if(identifier.equals("css")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(splitString[1])
                ));
            }

            if(identifier.equals("partialLink")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.partialLinkText(splitString[1])
                ));
            }

            if(identifier.equals("name")){
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.name(splitString[1])
                ));
            }
        }
        catch (ElementNotVisibleException e) {
            System.out.println("Element not visible after:  " + timeToWait + " seconds.");
        }
    }

    public String getDriversDirectory(){
        return System.getProperty("user.dir") + "\\src\\main\\resources\\webdrivers\\";
    }

    public WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", getDriversDirectory() + "chromedriver.exe");
        return new ChromeDriver();
    }

    public WebDriver getFirefoxDriver(){
        System.setProperty("webdriver.firefox.driver", getDriversDirectory() + "geckodriver.exe");
        return new FirefoxDriver();
    }

    public WebDriver getOperaDriver(){
        System.setProperty("webdriver.opera.driver", getDriversDirectory() + "operadriver.exe");
        return new OperaDriver();
    }

    public WebDriver getEdgeDriver(){
        System.setProperty("webdriver.firefox.driver", getDriversDirectory() + "msedgedriver.exe");
        return new EdgeDriver();
    }

    public WebDriver getSafariDriver(){
        System.setProperty("webdriver.opera.driver", getDriversDirectory() + "safaridriver.exe");
        return new SafariDriver();
    }

    public WebDriver getIEDriver(){
        System.setProperty("webdriver.firefox.driver", getDriversDirectory() + "iedriver.exe");
        return new InternetExplorerDriver();
    }
}
