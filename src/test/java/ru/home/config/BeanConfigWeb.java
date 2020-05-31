package ru.home.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.net.MalformedURLException;
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
//
    @Bean(value = "chrome")
    public WebDriver driverServiceChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions().addArguments("--headless"));
    }

//    @Bean(value = "chrome")
//    public WebDriver driverServiceChrome() throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        return new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub/"), new ChromeOptions());
//    }
}
