package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {
    //Login
    public WebElement email;

    public WebElement passwd;

    public WebElement SubmitLogin;

    //Create an account
    public WebElement email_create;

    @FindBy(id = "SubmitCreate")
    public WebElement submitCreate;

    @FindBy(xpath = "//*[@id=\"create-account_form\"]/h3")
    public WebElement pageSubheading;



}
