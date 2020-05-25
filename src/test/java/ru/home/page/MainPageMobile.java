package ru.home.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;

@Component
@Profile("mobile")
public class MainPageMobile implements MainPage {

    @Autowired
    @Qualifier("firefox")
    private WebDriver driver;

    @Value("${habr.url}")
    private String url;

    public void open() {
        driver.get(url);
    }

    public String openPost(int index) {
//        List<WebElement> posts = driver.findElements(By.cssSelector("article.post>h2>a"));
        List<WebElement> posts = driver.findElements(By.cssSelector("article.post>h2>a"));
        WebElement post = posts.get(index - 1);
        String title = post.getText();
        post.click();
        return title;
    }

    public void verify(String postTitle) {
        assertThat(driver.getTitle(), startsWith(postTitle));
        assertThat(driver.getCurrentUrl(), startsWith(url + "post/"));
    }
}
