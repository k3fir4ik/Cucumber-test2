import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class TestContainers {

    @Rule
    public BrowserWebDriverContainer chromeContainer = new BrowserWebDriverContainer()
                    .withCapabilities(new FirefoxOptions());

    @Test
    public void testA() throws InterruptedException {
        chromeContainer.start();
        WebDriver driver = chromeContainer.getWebDriver();
        driver.get("https://google.ru");
        Thread.sleep(10000);
        chromeContainer.stop();
    }
}
