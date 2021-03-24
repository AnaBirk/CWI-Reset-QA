package pageObjects;

import elementMapper.MyAccountPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class MyAccountPage extends MyAccountPageElementMapper {
    public MyAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getPageHeadingMyAccount(){
        return pageHeadingMyAccount.getText();
    }

    public String MyPersonalInformation(){
        return headerUserInfo.getText();
    }

    public String navegationAccount(){
        return myAccountNavigation.getText();
    }

}

