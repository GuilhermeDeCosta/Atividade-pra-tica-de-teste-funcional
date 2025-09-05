package testes;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeTestAutomationTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testLoginPracticeAutomation() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        WebElement mensagem = driver.findElement(By.xpath("//h1"));
        assertTrue(mensagem.getText().contains("Logged In Successfully"));
    }
}
