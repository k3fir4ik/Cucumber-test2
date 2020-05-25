package ru.home.steps;

import cucumber.api.java.After;
import org.springframework.test.context.ContextConfiguration;
import ru.home.config.BeanConfigMobile;
import ru.home.config.BeanConfigWeb;
import ru.home.service.Driver;

@ContextConfiguration(classes = {BeanConfigWeb.class, BeanConfigMobile.class})
public class BasePageStepDefs {
//    public BasePageStepDefs() {
//        System.setProperty("platform", "mobile");
//    }

    @After
    public void tearDown() {
        Driver.clearDriver();
    }
}
