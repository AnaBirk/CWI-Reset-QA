package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageElementMapper {

    @FindBy(className ="lighter")
    public WebElement lighter;

    @FindBy(className ="navigation_page")
    public WebElement navigationPage;

    @FindBy(className ="heading-counter")
    public WebElement headingCounter;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]")
    public WebElement productImgLink;

    @FindBy(css = ".product-container")
    public WebElement product;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]")
    public WebElement buttonMoreAddToProductPage;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a")
    public WebElement productNameCategory;
}
