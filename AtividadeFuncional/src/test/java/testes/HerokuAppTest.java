package testes;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HerokuAppTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testLoginHerokuApp() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement successMessage = driver.findElement(By.id("flash"));
        assertTrue(successMessage.getText().contains("You logged into a secure area!"));
    }
}
