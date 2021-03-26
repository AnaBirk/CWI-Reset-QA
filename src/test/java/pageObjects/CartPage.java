package pageObjects;

import elementMapper.CartPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CartPage extends CartPageElementMapper {
    public CartPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getNameProductCart(){
        return productNameCart.getText();
    }

    @Step("Clicou no botão 'ProceedToCheckoutCart'")
    public void clickBtnProceedToCheckoutCart(){
        btnProceedToCheckoutCart.click();
    }
}
