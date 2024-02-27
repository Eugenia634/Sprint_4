package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.AboutRentOrderFlow;
import pages.ForWhomOrderFlow;
import pages.ImportantQuestions;
import pages.OrderFlow;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderFlowDataTest extends DriverForTest {

    private String name;
    private String surname;
    private String address;
    private String metro;
    private String phone;
    private String date;
    private String comment;

    public OrderFlowDataTest(String name, String surname, String address, String metro, String phone, String date, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] clientData() {
        return new Object[][] {
                { "Инна", "Иванова", "Питер, Мира, 56", "Марьина Роща", "+79167653412", "27.03.2024", "this is comment 1"},
                { "Игорь", "Петров", "Москва, Мира, 23", "Сокольники", "+79167653412",  "23.03.2024", "this is comment 2"},
        };
    }


    @Test
    public void orderingUpperOrderButton() {

        OrderFlow objOrderFlow = new OrderFlow(driver);
        objOrderFlow.clickCookieButton();
        objOrderFlow.clickUpperOrderButton();

        ForWhomOrderFlow objForWhomOrderFlow = new ForWhomOrderFlow(driver);

        objForWhomOrderFlow.sendNamePanel(name);
        objForWhomOrderFlow.sendSurnamePanel(surname);
        objForWhomOrderFlow.sendAddressPanel(address);
        objForWhomOrderFlow.selectMetroPanel(metro);
        objForWhomOrderFlow.sendPhonePanel(phone);
        objForWhomOrderFlow.clickFurtherButton();


        AboutRentOrderFlow objAboutRentOrderFlow = new AboutRentOrderFlow(driver);

        objAboutRentOrderFlow.sendWhenPanel(date);
        objAboutRentOrderFlow.setDurationPanel();
        objAboutRentOrderFlow.clickCheckBoxBlackPearlColour();
        objAboutRentOrderFlow.clickCheckBoxGreyDespairColour();
        objAboutRentOrderFlow.sendCommentPanel(comment);
        objAboutRentOrderFlow.clickOrderButton();
        objAboutRentOrderFlow.clickOrderButtonYes();


        String isDisplayed = new AboutRentOrderFlow(driver).isModalOrderWindowDisplayed();
        Assert.assertTrue("Текст элемента не соответствует ожидаемому", isDisplayed.contains("Заказ оформлен"));
//        Assert.assertTrue("Текст элемента не соответствует ожидаемому", isDisplayed.contains("Хотите оформить заказ?"));
    }

    @Test
    public void orderingByBelowOrderButton() {

        ImportantQuestions objImportantQuestions = new ImportantQuestions(driver);
        objImportantQuestions.scrollPageToEndOfList();

        OrderFlow objOrderFlowTest = new OrderFlow(driver);
        objOrderFlowTest.clickCookieButton();
        objOrderFlowTest.clickBelowOrderButton();

        // проверка появления формы заказа
        objOrderFlowTest.orderFormCheck();

        String isDisplayed = objOrderFlowTest.orderFormCheck();
        assertEquals("Для кого самокат", isDisplayed);

    }
}
