package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverForTest {
    protected WebDriver driver;
    public final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
     // driver = new ChromeDriver();
      driver = new FirefoxDriver();
        driver.get(URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
