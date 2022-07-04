package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver driver;

    @Before("@contact-us")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@contact-us")
    public void tearUp(){
        driver.quit();
    }

    public String generateRandomNumber(int lenght){
        return RandomStringUtils.randomNumeric(lenght);
    }

    public String generateRandoString(int lenght){
        return RandomStringUtils.randomAlphabetic(lenght);
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys( generateRandomNumber(10)+ "@mail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name = 'message']")).sendKeys("Hello Wolrd " + generateRandoString(20));
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value = 'SUBMIT']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_SubmissionMessage = driver.findElement(By.xpath("//div[@id = 'contact_reply']/h1"));
        Assert.assertEquals(contactUs_SubmissionMessage.getText(), "Thank You for your Message!");
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys(firstName);

    }

    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys(lastName);

    }

    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(email);

    }

    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment (String comment) {
        driver.findElement(By.xpath("//textarea[@name = 'message']")).sendKeys(comment);

    }

}
