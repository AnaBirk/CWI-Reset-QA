package pageObjects;

import elementMapper.CartShippingPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CartShippingPage extends CartShippingPageElementMapper {
    public CartShippingPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextShippingNameCart(){
        return shippingNameCart.getText();
    }

    public void clickCheckboxTermsOfServiceCart(){
        checkboxTermsOfServiceCart.click();
    }

    public void clickBtnProcessCarrierCart(){
        btnProcessCarrierCart.click();
    }
}
