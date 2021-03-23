package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;


public class BasePage {
    public static void mouseOver(WebElement element){
        Actions action = new Actions(Browser.getCurrentDriver());
        action.moveToElement(element).build().perform();
    }

}
