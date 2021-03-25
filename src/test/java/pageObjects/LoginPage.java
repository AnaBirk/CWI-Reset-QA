package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {
    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    //create an account
    public void fillEmailCreateAnAccount(String keys){
        email_create.sendKeys(keys);
    }

    public void clickSubmitCreateAnAccount(){
        submitCreate.click();
    }

    public void enterEmailAddress(String emailValue){
        fillEmailCreateAnAccount(emailValue);
        clickSubmitCreateAnAccount();
    }

    //Login
    @Step("Preencheu o email")
    public void fillEmail(){
        email.sendKeys("anabirk.ev@gmail.com");
    }

    @Step("Preencheu a senha")
    public void fillPassword(){
        passwd.sendKeys("123456");
    }

    @Step("Clicou em sign in")
    public void clickBtnSubmitLogin(){
        SubmitLogin.click();
    }

    public String getTextPageSubheading(){
        return pageSubheading.getText();
    }
}
