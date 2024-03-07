package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.AboutRentOrderFlow;
import pages.ForWhomOrderFlow;
import pages.OrderFlow;

@RunWith(Parameterized.class)
public class OrderFlowDataTest extends DriverForTest {

    private String name;
    private String surname;
    private String address;
    private String metro;
    private String phone;
    private String date;
    private String comment;

    private String buttonKind;

    public OrderFlowDataTest(String name, String surname, String address, String metro, String phone, String date, String comment, String buttonKind) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
        this.buttonKind = buttonKind;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] clientData() {
        return new Object[][] {
                { "Инна", "Иванова", "Питер, Мира, 56", "Марьина Роща", "+79167653412", "27.03.2024", "this is comment 1", "upperButton"},
                { "Игорь", "Петров", "Москва, Мира, 23", "Сокольники", "+79167653412",  "23.03.2024", "this is comment 2", "belowButton"},
        };
    }

    @Test
    public void orderingUpperOrderButton() {

        OrderFlow objOrderFlow = new OrderFlow(driver);
        objOrderFlow.clickCookieButton();
        if (buttonKind.equals("upperButton")){
            objOrderFlow.clickUpperOrderButton();
        } else objOrderFlow.clickBelowOrderButton();

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


        String confirmationText = new AboutRentOrderFlow(driver).isModalOrderWindowDisplayed();
        Assert.assertTrue("Текст элемента не соответствует ожидаемому", confirmationText.contains("Заказ оформлен"));
//      Assert.assertTrue("Текст элемента не соответствует ожидаемому", confirmationText.contains("Хотите оформить заказ?"));
    }
}
