package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static utils.Global_Vars.WEBDRIVERUNIVERSITY_HOMEPAGE_URL;

public class ContactUs_PO extends Base_PO {
    private @FindBy(xpath = "//input[@name = 'first_name']")
    WebElement firstName_TextField;
    private @FindBy(xpath = "//input[@name = 'last_name']")
    WebElement lastName_TextField;
    private @FindBy(xpath = "//input[@name = 'email']")
    WebElement email_TextField;
    private @FindBy(xpath =  "//textarea[@name = 'message']")
    WebElement comment_TextArea;
    private @FindBy(xpath = "//input[@value = 'SUBMIT']")
    WebElement submit_button;
    private @FindBy(xpath = "//div[@id = 'contact_reply']/h1")
    WebElement successfulSubmissionMessage;

    public ContactUs_PO(){
        super();
    }

    public void navigateTo_WebDriverUniversity_ContactUsPage(){
        navigate_URL(WEBDRIVERUNIVERSITY_HOMEPAGE_URL + "/Contact-Us/contactus.html");
    }

    public void setUnique_FirstName (){
        sendKeys(firstName_TextField, "AutoFN" + generateRandomNumber(5));
    }

    public void setUnique_LastName (){
        sendKeys(lastName_TextField, "AutoLN" + generateRandomNumber(5));
    }

    public void setUnique_email(){
        sendKeys(email_TextField, generateRandomNumber(10)+ "@mail.com");
    }

    public void setUnique_Comment(){
        sendKeys(comment_TextArea,"Hello Wolrd " + generateRandoString(20));
    }

    public void setSpecific_firstName(String firstName) {
        sendKeys(firstName_TextField, firstName);
    }

    public void setSpecific_lastName(String lastName) {
        sendKeys(lastName_TextField, lastName);
    }

    public void setSpecific_email(String email){
        sendKeys(email_TextField, email);
    }

    public void setSpecificComment(String comment){
        sendKeys(comment_TextArea, comment);
    }

    public void clickOn_SubmitButton(){
        waitForWebElementClick(submit_button);
    }

    public void validate_SuccessfulSubmissionMessage(){
        waitFor(successfulSubmissionMessage);
        Assert.assertEquals(successfulSubmissionMessage.getText(), "Thank You for your Message!");
    }
}
