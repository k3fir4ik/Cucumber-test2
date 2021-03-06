package ru.home.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Configuration
@ComponentScan("ru.home")
@PropertySource("classpath:habr-web.properties")
@Profile("web")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class BeanConfigWeb {

//    @Bean(value = "firefox")
//    public WebDriver driverServiceFirefox() {
//        WebDriverManager.firefoxdriver().setup();
//        return new FirefoxDriver();
//    }

//    @Bean(value = "chrome")
//    public WebDriver driverServiceChrome() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("83");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);
//        return new RemoteWebDriver(URI.create("http://192.168.0.101:4444/wd/hub/").toURL(), capabilities);
//    }

    @Bean(value = "chrome")
    public WebDriver driverServiceChrome() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}