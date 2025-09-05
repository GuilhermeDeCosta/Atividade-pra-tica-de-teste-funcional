package testes;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrangeHRMTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testLoginOrangeHRM() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement dashboard = driver.findElement(By.xpath("//h6[contains(text(),'Dashboard')]"));
        assertTrue(dashboard.isDisplayed());
    }
}
