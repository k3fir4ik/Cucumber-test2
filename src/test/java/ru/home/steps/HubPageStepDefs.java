package ru.home.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HubPageStepDefs {
    private static final Logger logger = LogManager.getLogger(HubPageStepDefs.class);
    private WebDriver driver;

//    public HubPageStepDefs() {
//        driver = driver();
//    }

    private String hubName;

    @Given("I am on hub page")
    public void iAmOnHubPage() {
        driver.get("https://habr.com/ru/hubs/");
    }

    By locator = By.cssSelector("#hubs .list-snippet__title-link");

    @When("I search hub {string}")
    public void iSearchHub(String hubName) {
        this.hubName = hubName;
        driver.findElement(By.cssSelector("#hubs_suggest")).sendKeys(hubName);
        driver.findElement(By.cssSelector("#hubs_suggest")).sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(locator, hubName));
    }

    @And("choose found hub")
    public void chooseFoundHub() {
    }
}
