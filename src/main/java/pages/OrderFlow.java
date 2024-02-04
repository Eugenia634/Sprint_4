package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFlow {

    private static WebDriver driver;

    // локаторы главной страницы
    // сообщение о куках
    private final By cookieButton = By.id("rcc-confirm-button");
    //первая кнопка Заказать вверху
    private final By upperOrderButton = By.className("Button_Button__ra12g");
    //вторая кнопка Заказать ниже
    private final By belowOrderButton = By.className("Home_FinishButton__1_cWm");

    public OrderFlow(WebDriver driver) {
        OrderFlow.driver = driver;
    }

    // метод проверяет, активна ли кнопка Заказать
    public boolean checkButton() {
        return driver.findElement(upperOrderButton).isEnabled();
    }

    // Кликнуть по кнопке куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // Кликнуть по кнопке по верхней кнопке Заказать
    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    // Кликнуть по кнопке по нижней кнопке Заказать
    public void clickBelowOrderButton() {
        driver.findElement(belowOrderButton).click();
    }
}
