package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.zaproxy.clientapi.core.ClientApi;
import task.pruebaTask;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static userinterfaces.Mapeo.*;


public class OwaspZap {

    private static final String ZAP_PROXYHOST = "localhost";
    private static final int ZAP_PROXYPORT = 8082;
    private static final String ZAP_URL = "https://www.saucedemo.com/";

    static WebDriver driver;

    public static void main(String args[]) throws Exception {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT)
                .setSslProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);
        WebDriverManager.chromedriver().setup();
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.setCapability(CapabilityType.PROXY, proxy);
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

            driver = new ChromeDriver(chromeOptions);
            driver.get(ZAP_URL);
           /* Enter.keyValues("standard_user").into(USERNAME);
            Enter.keyValues("secret_sauce").into(PASSWORD);
            Click.on(BTN);*/
            driver.findElement(By.name("user-name")).sendKeys("Prueba");
            waitMS(3000);
            driver.quit();

        ClientApi api = new ClientApi(ZAP_PROXYHOST, ZAP_PROXYPORT);

        String Report = new String(api.core.htmlreport(), StandardCharsets.UTF_8);
        Path filePath = Paths.get("E:\\Inteliij\\Pruebagitactions\\scan-results\\seleniumTests.html");
        if (!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
            Files.createFile(filePath);
        }
        Files.write(filePath, Report.getBytes());

    }

    public static void waitMS(int ms) throws Exception {
        Thread.sleep(ms);
    }
}
