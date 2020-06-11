package ru.home;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.BrowserWebDriverContainer;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Calendar;
import java.util.UUID;

public class Hooks {



//    @Before
//    public void beforeStart() {
//        System.out.println("Start test");
//    }

//    @Before
//    public void beforeStart() {
//        BrowserWebDriverContainer chromeContainer = new BrowserWebDriverContainer()
//                .withCapabilities(new ChromeOptions());
//    }

}
