package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartAddressPageElementMapper {
    @FindBy(className = "navigation_page")
    public WebElement addressNameCart;

    @FindBy(name = "processAddress")
    public WebElement btnprocessAddress;
}
