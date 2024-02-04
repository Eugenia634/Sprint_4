package pages;

import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class ImportantQuestions {

    private static WebDriver driver;
    private static final String[] questionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    private static final String[] answersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    public ImportantQuestions(WebDriver driver) {
        this.driver = driver;
    }

    //Прокрутка главной страницы до последнего элемента списка
    public void scrollPageToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(questionsArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }

    // Клик по стрелке выпадающего спискa
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionsArray[questionNumber])));
        driver.findElement(By.id(questionsArray[questionNumber])).click();
    }

    // Проверка текста в открытой панели
    public static void checkTextInOpenPanel(String expectedText, int answerNumber) {
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answersArray[answerNumber])));
        String answerText = driver.findElement(By.id(answersArray[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }


    //Метод для клика по элементу
    public void clickQuestionButton (int index){
        driver.findElement(By.id(questionsArray[index])).click();
    }

    //Метод для получения текста элемента
    public static String getText(int index){
        String question ="accordion__heading-";
        String answer = "accordion__panel-";
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(questionsArray[index])));
        return driver.findElement(By.id(answersArray[index])).getText();
    }
}