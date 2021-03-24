package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageElementMapper {

    @FindBy(className = "page-heading")
    public WebElement pageHeadingMyAccount;

    @FindBy(className = "account")
    public WebElement headerUserInfo;

    @FindBy(className="navigation_page")
    public WebElement myAccountNavigation;



}
