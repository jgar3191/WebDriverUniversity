package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Global_Vars.WEBDRIVERUNIVERSITY_HOMEPAGE_URL;

public class Login_PO extends Base_PO {
    private @FindBy(id = "text")
    WebElement username_TextField;
    private @FindBy(id = "password")
    WebElement password_textField;
    private @FindBy(id = "login-button")
    WebElement login_button;

    public Login_PO(){
        super();
    }

    public void navigateTo_WebDriverUniversity_LoginPage(){
        navigate_URL(WEBDRIVERUNIVERSITY_HOMEPAGE_URL + "/Login-Portal/index.html?");
    }

    public void setUsername(String username) {
        sendKeys(username_TextField, username);
    }

    public void setPassoword(String password){
        sendKeys(password_textField, password);
    }

    public void clickOn_LoginButton(){
        waitForWebElementClick(login_button);
    }

    public void validate_SuccessfulLoginMessage(){
        waitForAlert_ValidateText("validation succeeded");
    }

    public void validate_UnsuccessfulLoginMessage(){
        waitForAlert_ValidateText("validation failed");
    }

}
