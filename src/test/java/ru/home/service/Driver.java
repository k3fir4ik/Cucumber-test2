package ru.home.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver driver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            driver().manage().window().maximize();
        }
        return driver;
    }

    public static void clearDriver() {
        if (driver != null) {
            System.out.println("quit start");
            driver.quit();
            driver = null;
            System.out.println("quit finish");
        }
    }
}
