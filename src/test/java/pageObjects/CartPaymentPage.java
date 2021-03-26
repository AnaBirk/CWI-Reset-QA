package pageObjects;

import elementMapper.CartPaymentPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CartPaymentPage extends CartPaymentPageElementMapper {
    public CartPaymentPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextYourPaymentNameCart(){
        return yourPaymentNameCart.getText();
    }

    @Step("Clicou em Pay by bank wire(order processing will be longer)")
    public void clickPayByBankCart(){
        payByBankCart.click();
    }

    public String getTextBankWireNameCart(){
        return bankWireNameCart.getText();
    }

    @Step ("Clicou no botão 'I confirm My Order'")
    public void clickBtnIConfirmMyOrder(){
        btnIConfirmMyOrder.click();
    }

/*
    public String getValueFinalPrice(){
        return finalPrice.getText();
    }

    public String getValueConfirmFinalPrice(){
        return confirmFinalPrice.getText();
    }*/

}
