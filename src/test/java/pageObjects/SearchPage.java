package pageObjects;

import elementMapper.SearchPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SearchPage extends SearchPageElementMapper {

    public SearchPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }
    public String getTextNavigationPage(){
        return navigationPage.getText();
    }


    public String getTextLighter(){
       return lighter.getText();
    }

    public String getTextHeadingCounter(){
        return headingCounter.getText();
    }

    public boolean isSearchPage(){
        return getTextNavigationPage().equals("Search");
    }

    @Step("Hover na imagem do produto e click no botão More ")
    public void clickProductAddToProductPage(){
        BasePage.mouseOver(product);
        buttonMoreAddToProductPage.click();
    }

    public String getProductNameCategory(){
        //pega o texto que está nesse elemento
        return productNameCategory.getText();
    }

}



