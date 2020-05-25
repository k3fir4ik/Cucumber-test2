package ru.home.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("ru.home")
@PropertySource("classpath:habr-mobile.properties")
@Profile("mobile")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class BeanConfigMobile {
    public BeanConfigMobile() {
        System.out.println("mobile");
    }

    @Bean(value = "firefox")
    public WebDriver driverServiceFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Bean(value = "chrome")
    public WebDriver driverServiceChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
