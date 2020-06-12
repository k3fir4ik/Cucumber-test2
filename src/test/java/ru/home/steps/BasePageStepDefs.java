package ru.home.steps;

import cucumber.api.java.After;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.home.config.BeanConfigMobile;
import ru.home.config.BeanConfigWeb;
import ru.home.service.Driver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

@ContextConfiguration(classes = {BeanConfigWeb.class, BeanConfigMobile.class})
public class BasePageStepDefs {
//    public BasePageStepDefs() {
//        System.setProperty("platform", "mobile");
//    }

    @Autowired
    WebDriver driver;

    @After
    public void tearDown() throws IOException {
        makeScreenShot();
        Driver.clearDriver();
    }

    @Attachment(value = "ScreenshotAttachment", type = "image/png")
    public byte[] makeScreenShot() throws IOException {
        BufferedImage bufferedImage = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(10))
                .takeScreenshot(driver)
                .getImage();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);

        byteArrayOutputStream.flush();
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        String fileName = String.valueOf("target" + File.separator + "allure-results" + File.separator + UUID.randomUUID() + ".png");
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            byteArrayOutputStream.writeTo(outputStream);
        }
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        return imageBytes;

//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
