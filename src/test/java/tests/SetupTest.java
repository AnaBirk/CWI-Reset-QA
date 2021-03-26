package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import pageObjects.*;
import utils.Browser;
import utils.utils;
import static org.junit.Assert.*;


@Feature("Testes site de ecommerce")
public class SetupTest extends Base{
        @Test
        @Story("Abrir o site")
        public void testOpeningBrowserAndLoadPage(){
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl()));
            System.out.println("Funcionou!");
        }


        @Test
        @Story("Realizar o login")
        public void testLogin(){
            //Instanciando e iniciando a classe
            HomePage home = new HomePage();
            LoginPage login = new LoginPage();

            home.clickBtnLogin();
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=authentication&back=my-account")));

            login.fillEmail();
            login.fillPassword();
            login.clickBtnSubmitLogin();
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=my-account")));
        }

        @Test
        @Story("Pesquisar Adress na barra de pesquisa")
         public void testeSearch(){

            //iniciar as páginas
            HomePage home = new HomePage();
            SearchPage search = new SearchPage();

            String quest = "DRESS";
            String questResultQtd = "7 results have been found.";

            //Fazer a pesquisa
            home.doSearch(quest);

            //Validar a pesquisa
            assertTrue(search.isSearchPage());
            assertEquals(search.getTextLighter().replace("\"", ""), quest);
            assertThat(search.getTextHeadingCounter(), CoreMatchers.containsString(questResultQtd));

        }

        @Test
        @Story("Abrir página de produto PDP")
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
        @Story("Adicionar produto ao carrinho")
         public void testeAddProductToCart(){
            //acessar a página de produto
            testeAddProductToProductPage();
            //iniciar as páginas
            ProductPage product = new ProductPage();

            //vou usar para válidar o nome no carrinho
            String nomeProductPDP = product.getProductNamePDP();

            //clicar no botão de adicionar ao carrinho
            product.clickBtnAddToCart();

            //Clicar no botão proceed do checkout
            product.clickBtnProceedToCheckout();
        }

    @Test
    @Story("Criar uma conta")
    public void testCreateAnAccount() {
        HomePage index = new HomePage();
        LoginPage authentication = new LoginPage();
        CreateAnAccountPage createAccount = new CreateAnAccountPage();
        MyAccountPage accountPage = new MyAccountPage();

        String fristNameValue = "Ana Caroline";
        String lastNameValue = "Birk";
        String fullName = fristNameValue.concat(" " + lastNameValue);
        String emailValue = "birk01@gmail.com";
        String emailValueAccount = emailValue;
        String textCreateAnAccount = "Create an account";
        String accountCreated = "My account";

        index.clickBtnLogin();

        //Verificação: fui redirecionada para a página "Authentication"?
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=authentication&back=my-account")));

        //Digita um e-mail válido e clica no botão "Create an account"
        authentication.enterEmailAddress(emailValue);

        //Validação: estou na página de "Create an account"?
        assertTrue(createAccount.getTextpageSubHeading().equals(textCreateAnAccount.toUpperCase()));

        //Preenchimento dos dados solicitados em YOUR PERSONAL INFORMATION
        createAccount.personalInformation();

        //Verificação: o email que digitei no input "id="email_create" é o mesmo do input id="email"?
        assertTrue(createAccount.getEmailAccountValue().contains(emailValueAccount));

        //Preenchimento dos dados solicitados em YOUR ADDRESS
        createAccount.address();

        //Verificações: os inputs de "fristname" e "lastname" condizem com os inputs  "customer_firstname" e "customer_lastname"?
        assertThat(createAccount.getFirstNameAddressValue(), CoreMatchers.containsString(fristNameValue));
        assertThat(createAccount.getLastNameAddressValue(), CoreMatchers.containsString(lastNameValue));

        //Registrar
        createAccount.clickSubmitBtnRegister();

        //Verificações para validar se a conta foi criada e fui redirecionada para "My account"
        assertTrue(accountPage.getPageHeadingMyAccount().equals(accountCreated.toUpperCase()));
        assertTrue(accountPage.MyPersonalInformation().equals(fullName));
        assertThat(accountPage.navegationAccount(), CoreMatchers.containsString(accountCreated));
    }

}



