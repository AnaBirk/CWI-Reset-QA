package pageObjects;

import elementMapper.CartAddressPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CartAddressPage extends CartAddressPageElementMapper {
    public CartAddressPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextAddressNameCart(){
       return addressNameCart.getText();
    }

    @Step("Clicou no botão 'Proceed do checkout'")
    public void clickBtnprocessAddress(){
        btnprocessAddress.click();
    }
}
