package pageObjects;

import elementMapper.HomePageElementMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends HomePageElementMapper {
    public HomePage(){
        //Faz com que os elementos que estão nessa página são iniciados (c/ o PageFactory)
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void clickBtnLogin(){
        login.click();
    }
}
