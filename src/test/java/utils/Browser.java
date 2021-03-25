package utils;

import com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    //Gerando o WebDriver
    public static WebDriver getCurrentDriver(){
        if(driver == null){
            try {
                ChromeOptions capability = new ChromeOptions();
                //Onde está rodando o serviço do chromeDriver e opções onde meu chrome será instânciado
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability );
                //Garantir que ações no browser não fiquem infinitamente esperando, como parametro precisa passar meu driver o tempo máximo que ele deve esperar quebrar o teste
                wait = new WebDriverWait(driver, 30);
                //Máximizar o browser para não dar nenhuma quebra de layout
                driver.manage().window().maximize(); // com esse comando vai startar o browser e já máximizar ele
               //
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Tempo máximo de carregar a página
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return driver;
    }

    //Método que fecha o driver
    public  static void close(){
        getCurrentDriver().quit();
        driver = null;
    }
    //
    public static void loadPage(String url) {
        getCurrentDriver().get(url);
    }

    public static void print(){
        //Tira o print
        byte[] screenshooByts = (((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        InputStream screenshootStream = new ByteArrayInputStream(screenshooByts);
        Allure.addAttachment("Screenshoot test: ",screenshootStream);

    }
}


