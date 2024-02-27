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
    // появление формы заказа
    private final By orderForm = By.className("Order_Header__BZXOb");

    public OrderFlow(WebDriver driver) {
        OrderFlow.driver = driver;
    }

    // Кликнуть по кнопке куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // Кликнуть по верхней кнопке Заказать
    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    // Кликнуть по нижней кнопке Заказать
    public void clickBelowOrderButton() {
        driver.findElement(belowOrderButton).click();
    }
   // метод проверяет есть ли форма заказа
    public String orderFormCheck() {
        return driver.findElement(orderForm).getText();
    }
}
