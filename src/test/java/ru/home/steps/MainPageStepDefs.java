package ru.home.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import cucumber.api.java.ru.Дано;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.home.service.MainPageService;

import static org.junit.Assert.assertThat;

public class MainPageStepDefs {
    private static final Logger logger = LogManager.getLogger(MainPageStepDefs.class);
    private String postTitle;

    @Autowired
    private MainPageService mainPageService;

//    public MainPageStepDefs() {
//        mainPageService = new MainPageService();
//    }

    @Given("I am on main page")
    public void openMainPage() {
        mainPageService.open();
    }

    @When("to open {int} post")
    public void toOpenPost(int index) {
        postTitle = mainPageService.openPost(index - 1);
    }

    @Then("i am on post page")
    public void iAmOnPostPage() {
        mainPageService.verify(postTitle);
    }

    @And("each post has hub label {string}")
    public void eachPostHasHubLabel(String arg0) {
    }

    @Then("I am on result page with {string}")
    public void iAmOnResultPageWith(String searchTerm) {
    }

    @When("I search {string}")
    public void iSearch(String searchTerm) {
    }

//    @Дано("открыть главную страницу Habr")
//    public void открытьГлавнуюСтраницуHabr() {
//        openMainPage();
//    }
}
