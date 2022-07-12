package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import static utils.Global_Vars.DEFAULT_EXPLICIT_TIMEOUT;

public class Base_PO {
    public Base_PO(){
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }

    public void navigate_URL(String url){
        getDriver().get(url);
    }

    public String generateRandomNumber(int lenght){
        return RandomStringUtils.randomNumeric(lenght);
    }

    public String generateRandoString(int lenght){
        return RandomStringUtils.randomAlphabetic(lenght);
    }

    public void sendKeys(By locator, String input){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(input);
    }

    public void sendKeys(WebElement element, String input){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(input);
    }

    public void waitForWebElementClick(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitForWebElementClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlert_ValidateText(String AlertMessage){
       WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
       wait.until(ExpectedConditions.alertIsPresent());
       String alertMessage = getDriver().switchTo().alert().getText();
       Assert.assertEquals(alertMessage, AlertMessage);
       clickAccept_Alert();
    }

    public void clickAccept_Alert(){
        getDriver().switchTo().alert().accept();
    }

    public void waitFor(By selector){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public void waitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
