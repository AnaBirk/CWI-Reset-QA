package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Browser;
import utils.utils;

import static org.junit.Assert.assertTrue;

public class SetupTest extends Base{
        @Test
        public void testOpeningBrowserAndLoadPage(){
            //assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl()));
            System.out.println("Funcionou!");
        }

        @Test
        public void testLogin(){
            //Instanciando e iniciando a classe
            HomePage home = new HomePage();
            LoginPage login = new LoginPage();

            home.clickBtnLogin();
            System.out.println("Click Sign In e direcionou para a página de login");
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=authentication&back=my-account")));


            login.fillEmail();
            System.out.println("Preencheu o email");

            login.fillPassword();
            System.out.println("Preencheu a senha");

            login.clickBtnSubmitLogin();
            System.out.println("Click no button Sign In!!");
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=my-account")));
            System.out.println("Validou URL da conta");
            System.out.println("Validou a conta no site");

        }
    }
