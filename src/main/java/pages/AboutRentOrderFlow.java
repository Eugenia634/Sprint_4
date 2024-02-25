package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentOrderFlow {
    WebDriver driver;

    // Локаторы элементов второй страницы заказа

    // локатор даты доставки
    private final By whenPanel = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // локатор срока аренды
    private final By durationPanelField = By.className("Dropdown-placeholder");
    // список срока аренды
    private final By durationPanel = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    // локатор цвета самоката "Черный жемчуг"
    private final By checkBoxBlackPearlColour = By.xpath(".//input[@id='black']");
    // локатор цвета самоката "Серая безысходность
    private final By checkBoxGreyDespairColour = By.xpath(".//input[@id='grey']");
    // локатор для комментария курьеру
    private final By commentPanel = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    // локатор для кнопки заказать
    private final By orderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    // локатор для кнопки Да
    private final By orderButtonYes = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    //Локатор модального окна
    private final By modalOrderWindow = By.className("Order_ModalHeader__3FDaJ");


    //Модальное окно Заказ Оформлен
   public String isModalOrderWindowDisplayed() {
        return driver.findElement(modalOrderWindow).getText();
    }

    public AboutRentOrderFlow(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для работы с элементами второй страницы заказа
    //Ввод даты доставки
    public void sendWhenPanel(String When) {
        driver.findElement(whenPanel).sendKeys(When);
        driver.findElement(whenPanel).sendKeys(Keys.ENTER);
    }

    //срок аренды
    public void setDurationPanel() {
        driver.findElement(durationPanelField).click();
        driver.findElement(durationPanel).click();
    }
  //  durationPanel

    // Выбор цвета самоката "Черный жемчуг"
    public void clickCheckBoxBlackPearlColour() {
        driver.findElement(checkBoxBlackPearlColour).click();
    }

    // Выбор цвета самоката "Серая безысходность"
    public void clickCheckBoxGreyDespairColour() {
        driver.findElement(checkBoxGreyDespairColour).click();
    }

    // Оставить комментарий
    public void sendCommentPanel(String Comment) {
        driver.findElement(commentPanel).sendKeys(Comment);
    }

    //Клик по Кнопке Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Клик по кнопке Да
    public void clickOrderButtonYes() {
        driver.findElement(orderButtonYes).click();
    }
}



