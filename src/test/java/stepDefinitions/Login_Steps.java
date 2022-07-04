package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {
    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
    }

    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
    }

    @Then("I should be presented with a successful login alert message")
    public void i_should_be_presented_with_a_successful_login_alert_message() {
    }
}
