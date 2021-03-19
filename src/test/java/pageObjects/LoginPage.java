package pageObjects;

import elementMapper.LoginPageElementMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {
    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void fillEmail(){
        email.sendKeys("anabirk.ev@gmail.com");
    }

    public void fillPassword(){
        passwd.sendKeys("123456");
    }

    public void clickBtnSubmitLogin(){
        SubmitLogin.click();
    }




}
