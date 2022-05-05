package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class SeleniumDemo {

    private static final String ZAP_PROXYHOST = "localhost";
    private static final int ZAP_PROXYPORT = 8082;
    public static WebDriver browser;

    public static Driver web() {
        //Proxy proxy = new Proxy(); //comentar al subir pipeline
        //proxy.setHttpProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT).setSslProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT); //comentar al subir pipeline

        String downloadPath = "scr\\test\\resources\\data\\";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        HashMap<String, Object> preferences = new HashMap<String, Object>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); //pipeline
        options.addArguments("--single-process"); //pipeline
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-infobars");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--incognito", "--start-maximized");
        options.setExperimentalOption("prefs", preferences);

       /* options.setCapability(CapabilityType.PROXY, proxy); //comentar al subir pipeline
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);*/


        browser = new ChromeDriver(options);
        return new Driver();
    }

    public static WebDriver inThePage(String url) {
        browser.get(url);
        return browser;
    }

    public static WebDriver inTheStage() {
        return browser;
    }

    public static WebElement expandRootElement(WebElement element) {

        return (WebElement) ((JavascriptExecutor) browser).executeScript("return arguments[0].shadowRoot",
                element);

    }
}
