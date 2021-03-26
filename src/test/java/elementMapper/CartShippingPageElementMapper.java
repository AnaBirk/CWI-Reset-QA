package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartShippingPageElementMapper {
    @FindBy(className="navigation_page")
    public WebElement shippingNameCart;

    @FindBy(name="cgv")
    public WebElement checkboxTermsOfServiceCart;

    @FindBy(name="processCarrier")
    public WebElement btnProcessCarrierCart;



}
