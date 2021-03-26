package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPaymentPageElementMapper {
    @FindBy(className = "navigation_page")
    public WebElement yourPaymentNameCart;

    @FindBy(className = "bankwire")
    public WebElement payByBankCart;

    @FindBy(className = "page-heading")
    public WebElement bankWireNameCart;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    public WebElement btnIConfirmMyOrder;

    @FindBy(id = "amount")
    public WebElement finalPrice;

    @FindBy(css = ".box .price")
    public WebElement confirmFinalPrice;

}
