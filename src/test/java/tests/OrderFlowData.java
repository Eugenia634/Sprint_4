package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.AboutRentOrderFlow;
import pages.ForWhomOrderFlow;
import pages.ImportantQuestions;
import pages.OrderFlow;

import static org.junit.Assert.*;

public class OrderFlowData extends DriverForTest {

    @Test
    public void orderingUpperOrderButton() {

        OrderFlow objOrderFlow = new OrderFlow(driver);
        objOrderFlow.clickCookieButton();
        objOrderFlow.clickUpperOrderButton();

        ForWhomOrderFlow objForWhomOrderFlow = new ForWhomOrderFlow(driver);

        objForWhomOrderFlow.sendNamePanel("Инна");
        objForWhomOrderFlow.sendSurnamePanel("Иванова");
        objForWhomOrderFlow.sendAddressPanel("Питер, Мира, 56");
        objForWhomOrderFlow.selectMetroPanel("Марьина Роща");
        objForWhomOrderFlow.sendPhonePanel("+79167653412");
        objForWhomOrderFlow.clickFurtherButton();


        AboutRentOrderFlow objAboutRentOrderFlow = new AboutRentOrderFlow(driver);

        objAboutRentOrderFlow.sendWhenPanel("02.03.2024");
        objAboutRentOrderFlow.setDurationPanel();
        objAboutRentOrderFlow.clickCheckBoxBlackPearlColour();
        objAboutRentOrderFlow.clickCheckBoxGreyDespairColour();
        objAboutRentOrderFlow.sendCommentPanel("Без комментариев.");
        objAboutRentOrderFlow.clickOrderButton();
        objAboutRentOrderFlow.clickOrderButtonYes();


        String isDisplayed = new AboutRentOrderFlow(driver).isModalOrderWindowDisplayed();
        Assert.assertTrue(isDisplayed.contains("Заказ оформлен"));
    }

    @Test
    public void orderingByUpperOrderButton() {

        ImportantQuestions objImportantQuestions = new ImportantQuestions(driver);
        objImportantQuestions.scrollPageToEndOfList();

        OrderFlow objOrderFlowTest = new OrderFlow(driver);
        objOrderFlowTest.clickCookieButton();
        objOrderFlowTest.clickBelowOrderButton();

        ForWhomOrderFlow objForWhomOrderFlow = new ForWhomOrderFlow(driver);

        objForWhomOrderFlow.sendNamePanel("Игорь");
        objForWhomOrderFlow.sendSurnamePanel("Петров");
        objForWhomOrderFlow.sendAddressPanel("Москва, Мира, 23");
        objForWhomOrderFlow.selectMetroPanel("Сокольники");
        objForWhomOrderFlow.sendPhonePanel("+79167653412");
        objForWhomOrderFlow.clickFurtherButton();


        AboutRentOrderFlow objAboutRentOrderFlow = new AboutRentOrderFlow(driver);

        objAboutRentOrderFlow.sendWhenPanel("05.05.2024");
        objAboutRentOrderFlow.setDurationPanel();
        objAboutRentOrderFlow.clickCheckBoxBlackPearlColour();
        objAboutRentOrderFlow.sendCommentPanel("Привет!");
        objAboutRentOrderFlow.clickOrderButton();
        objAboutRentOrderFlow.clickOrderButtonYes();

        String isDisplayed = new AboutRentOrderFlow(driver).isModalOrderWindowDisplayed();
        Assert.assertTrue(isDisplayed.contains("Заказ оформлен"));
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
