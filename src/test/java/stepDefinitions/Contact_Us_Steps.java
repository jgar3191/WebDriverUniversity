package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import pageObjects.ContactUs_PO;
import pageObjects.Base_PO;

public class Contact_Us_Steps extends Base_PO {
    private ContactUs_PO contactUs_PO;

    public Contact_Us_Steps(ContactUs_PO contactUs_PO){
        this.contactUs_PO = contactUs_PO;
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        contactUs_PO.navigateTo_WebDriverUniversity_ContactUsPage();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contactUs_PO.setUnique_FirstName();
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contactUs_PO.setUnique_LastName();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contactUs_PO.setUnique_email();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contactUs_PO.setUnique_Comment();
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        contactUs_PO.clickOn_SubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        contactUs_PO.validate_SuccessfulSubmissionMessage();
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        contactUs_PO.setSpecific_firstName(firstName);
    }

    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contactUs_PO.setSpecific_lastName(lastName);
    }

    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        contactUs_PO.setSpecific_email(email);
    }

    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment (String comment) {
        contactUs_PO.setSpecificComment(comment);
    }

}
