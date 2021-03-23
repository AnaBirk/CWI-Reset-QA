package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import utils.Browser;
import utils.utils;

import static org.junit.Assert.*;

public class SetupTest extends Base{

        public void testOpeningBrowserAndLoadPage(){
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl()));
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

        @Test
         public void testeSearch(){

            String quest = "DRESS";
            String questResultQtd = "7 results have been found.";
            //iniciar as páginas
            HomePage home = new HomePage();
            SearchPage search = new SearchPage();

            //Fazer a pesquisa
            home.doSearch(quest);

            //Validar a pesquisa
            assertTrue(search.isSearchPage());
            assertEquals(search.getTextLighter().replace("\"", ""), quest);
            assertThat(search.getTextHeadingCounter(), CoreMatchers.containsString(questResultQtd));

        }

        @Test
         public void testeAddProductToProductPage(){
            //Acessar a categoria dress
            testeSearch();

            //Iniciar as páginas
            SearchPage category = new SearchPage();
            ProductPage product = new ProductPage();
            //salva o nome do produto na página de search
            String nameProductCategory = category.getProductNameCategory();

            //Click em More e direcionar a direcionar para a página de produto
            category.clickProductAddToProductPage();

            //Verificar se produto está na página de detalhes correta
           assertTrue(product.getProductNamePDP().equals(nameProductCategory));
        }

        @Test
         public void testeAddProductToCart(){
            //acessar a página de produto
            testeAddProductToProductPage();
            //iniciar as páginas
            ProductPage product = new ProductPage();
            //vou usar para válidar o nome no carrinho
            String nomeProductPDP = product.getProductNamePDP();



        }

    }


