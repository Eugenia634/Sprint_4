package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.ImportantQuestions;
import pages.OrderFlow;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends DriverForTest{
    private final int quetionsIndex;
    private final String textAnswer;
    private final int answerIndex;

    public ImportantQuestionsTest(int quetions, int answer,  String text) {
        this.quetionsIndex = quetions;
        this.answerIndex = answer;
        this.textAnswer = text;
    }
    @Parameterized.Parameters
    public static Object[][] expectedAnswersParamList() {
        return new Object[][]{
                {0, 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void dropDownListTest() {

        OrderFlow objOrderFlow = new OrderFlow(driver);
        objOrderFlow.clickCookieButton();

        ImportantQuestions objMainList = new ImportantQuestions(driver);
        objMainList.scrollPageToEndOfList();
        objMainList.clickQuestionButton(quetionsIndex);

        assertEquals(textAnswer,ImportantQuestions.getText(answerIndex));
    }
}