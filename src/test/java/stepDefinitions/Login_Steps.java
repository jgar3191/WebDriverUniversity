package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {
    private WebDriver driver;
    @Before("@login")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with a successful login alert message")
    public void i_should_be_presented_with_a_successful_login_alert_message() {
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "validation succeeded");
        driver.switchTo().alert().accept();
    }

    @Then("I should be presented with an unsuccessful login alert message")
    public void i_should_be_presented_with_an_unsuccessful_login_alert_message() {
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "validation failed");
        driver.switchTo().alert().accept();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, expectedMessage);
        driver.switchTo().alert().accept();
    }

}
