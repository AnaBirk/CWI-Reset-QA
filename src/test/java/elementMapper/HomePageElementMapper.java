package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.CSS;

public class HomePageElementMapper {

    @FindBy(className = "login")
    public WebElement login;

    //Input onde digita o produto que deseja adicionar
   //@FindBy(id = "search_query_top")
    public WebElement search_query_top;

    //Botão de pesquisa
    @FindBy(css = "button.btn.btn-default.button-search")
    public WebElement submit_search;

    }
