package tests;

import org.junit.Test;
import pages.AboutRentOrderFlow;
import pages.ForWhomOrderFlow;
import pages.ImportantQuestions;
import pages.OrderFlow;

import static org.junit.Assert.assertTrue;

public class OrderFlow_Data extends DriverForTest {

    @Test
    public void OrderingUpperOrderButton() {

        OrderFlow objOrderFlow = new OrderFlow(driver);
       // objOrderFlow.checkUpperOrderButton();
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


        boolean isDisplayed = new AboutRentOrderFlow(driver).isModalOrderWindowDisplayed();
        assertTrue("Ошибка", isDisplayed);
    }

    @Test
    public void OrderingByUpperOrderButton() {

        ImportantQuestions objImportantQuestions = new ImportantQuestions(driver);
        objImportantQuestions.scrollPageToEndOfList();


        OrderFlow objOrderFlow_Test = new OrderFlow(driver);
        objOrderFlow_Test.clickCookieButton();
        objOrderFlow_Test.clickUpperOrderButton();


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

        boolean isDisplayed = new AboutRentOrderFlow(driver).isModalOrderWindowDisplayed();
        assertTrue("Ошибка...", isDisplayed);
    }
}
