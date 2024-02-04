package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ForWhomOrderFlow {
    private final WebDriver driver;
    // локаторы элементов первой страницы заказа
    // локатор имени
    private final By namePanel = By.xpath(".//input[@placeholder = '* Имя']");
    // локатор фамилии
    private final By surnamePanel = By.xpath(".//input[@placeholder = '* Фамилия']");
    // локатор адреса
    private final By addressPanel = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // локатор выбора метро
    private final By metroPanel = By.xpath(".//input[@placeholder = '* Станция метро']");
    // локатор тел. номера
    private final By phonePanel = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By furtherButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");


    public ForWhomOrderFlow(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadHeader() {
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("namePanel")));
    }

    //Методы для работы с элементами первой страницы заказа
    // заполнение поля Имя
    public void sendNamePanel(String Name) {
        driver.findElement(namePanel).sendKeys(Name);
    }

    // заполнение поля Фамилия
    public void sendSurnamePanel(String Surname) {
        driver.findElement(surnamePanel).sendKeys(Surname);
    }

    //заполнение адреса доставки
    public void sendAddressPanel(String Address) {
        driver.findElement(addressPanel).sendKeys(Address);
    }

    // Выбор станции метро
    public void selectMetroPanel(String deliveryMetroStation) {
        driver.findElement(metroPanel).click();
        driver.findElement(metroPanel).sendKeys(deliveryMetroStation);
        driver.findElement(metroPanel).sendKeys(Keys.DOWN, Keys.ENTER);
    }

    // заполнение телефона клиента
    public void sendPhonePanel(String phoneNumber) {
        driver.findElement(phonePanel).sendKeys(phoneNumber);
    }

    // Клик по кнопке "Далее"
    public void clickFurtherButton() {
        driver.findElement(furtherButton).click();
    }
}