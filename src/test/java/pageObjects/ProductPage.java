package pageObjects;

import elementMapper.ProductPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProductPage extends ProductPageElementMapper {
    public ProductPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getProductNamePDP(){
        return productName.getText();
    }

    public void clickBtnAddToCart(){
        btnAddToCart.click();
    }

    public void clickBtnProceedToCheckout(){
        btnProceedToCheckout.click();
    }
}
