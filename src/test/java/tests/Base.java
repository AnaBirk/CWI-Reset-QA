package tests;

import org.junit.After;
import org.junit.Before;
import utils.Browser;
import utils.utils;

public class Base {
    //antes dos testes iniciarem quero que abra o Browser e carregue a URL base
    // Quando finalizarem os testes, quero que feche o Browser após os testes rodarem
        //Os métodos acima já estão implementados na classe Browser, mas precisam ser executados

    //Carregamento do Browser:
    @Before // Roda antes de todos os testes, usá-se uma anotação do junit (nesse caso @Before)
    public void setup(){
        Browser.loadPage(utils.getBaseUrl());
    }

    @After
    public void tearDown(){
        Browser.print();
        Browser.close();
    }
}
