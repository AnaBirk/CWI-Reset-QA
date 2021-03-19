package tests;

import org.junit.Test;
import org.openqa.selenium.By;
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
            //Seleciono a classe > método dentro dela que quero acessar > localizo o elemento por classname > click nele;
           Browser.getCurrentDriver().findElement(By.className("login")).click();
           System.out.println("Click Sign In e direcionou para a página de login");
           //Validar se realmente clicou no login:
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=authentication&back=my-account")));
            //Inserir um e-mail e senha já cadastrado e clicar no button "Sign In"
            Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("anabirk.ev@gmail.com");
            System.out.println("Preencheu o email");
            Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("123456");
            System.out.println("Preencheu a senha");
            Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
            System.out.println("Click no button Sign In!!");
            //Saber se realmente entrou na conta
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=my-account")));
            System.out.println("Validou URL da conta");
            assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
            System.out.println("Validou a conta no site");
        }


    }
