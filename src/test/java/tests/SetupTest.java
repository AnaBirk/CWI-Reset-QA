package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.*;
import utils.Browser;
import utils.utils;

import java.util.Objects;

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
            String questResultQtd = "7";

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

            //Click em More e direcionar para a página de produto
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
            CartPage cart = new CartPage();

            //vou usar para válidar o nome no carrinho
            String nomeProductPDP = product.getProductNamePDP();

            //clicar no botão de adicionar ao carrinho
            product.clickBtnAddToCart();

            //Clicar no botão proceed do checkout
            product.clickBtnProceedToCheckout();

            //Validações
            //Nome do produto
            assertTrue(cart.getNameProductCart().equals(nomeProductPDP));
        }
        @Test
        @Story("Fazer a compra dos produtos que estão no carrinho")
        public void testeCheckout() {

            LoginPage login = new LoginPage();
            HomePage home = new HomePage();
            MyAccountPage account = new MyAccountPage();
            CartPage cart = new CartPage();
            CartAddressPage address = new CartAddressPage();
            CartShippingPage shipping = new CartShippingPage();
            CartPaymentPage payment = new CartPaymentPage();

            String addressNavText = "Addresses";
            String shippingNameCartText = "Shipping";
            String paymentCartText = "Your payment method";
            String bankWireText = "ORDER SUMMARY";
            //String confirmPrice = payment.getValueFinalPrice();

            home.clickBtnLogin();
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(utils.getBaseUrl().concat("/index.php?controller=authentication&back=my-account")));

            testLogin();
            account.clickLogoPage();

            testeAddProductToCart();

            //Clicar no botão Proceed to checkout
            cart.clickBtnProceedToCheckoutCart();

            //Validar se está na parte de address
           assertTrue(address.getTextAddressNameCart().equals(addressNavText));

            //clicar no  botão de Proceed to checkout
            address.clickBtnprocessAddress();

            //Validar se está na parte de Shipping
            assertTrue(shipping.getTextShippingNameCart().equals(shippingNameCartText));

            //clicar em I agree to the terms of service and will adhere to them unconditionally. (Read the Terms of Service)
            shipping.clickCheckboxTermsOfServiceCart();

            //clicar no  botão de Proceed to checkout
            shipping.clickBtnProcessCarrierCart();

            //validar se está na página de  > Your payment method
            assertTrue(payment.getTextYourPaymentNameCart().equals(paymentCartText));

            //clicar em pay by bank wire
            payment.clickPayByBankCart();

            //validar a página
            assertTrue(payment.getTextBankWireNameCart().equals(bankWireText));

            //clicar no botão i confirm my ordem
            payment.clickBtnIConfirmMyOrder();

            //Confirmar ordem

            //assertTrue(payment.getValueConfirmFinalPrice().equals(confirmPrice));
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
        String emailValue = "birk8s01@gmail.com";
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



