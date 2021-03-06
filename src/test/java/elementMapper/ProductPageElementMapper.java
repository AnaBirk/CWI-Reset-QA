package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(css = ".primary_block .pb-center-column h1")
    public WebElement productName;

    @FindBy(css = "#add_to_cart > button")
    public WebElement btnAddToCart;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")
    public WebElement btnProceedToCheckout;

}
