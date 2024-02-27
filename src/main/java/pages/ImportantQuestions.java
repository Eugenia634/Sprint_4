package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class ImportantQuestions {

    private static WebDriver driver;
    private static final String[] QUESTIONS_ARRAY = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    private static final String[] ANSWERS_ARRAY = new String[]{
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
        WebElement lastQuestionArrow = driver.findElement(By.id(QUESTIONS_ARRAY[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }

    //Метод для клика по элементу
    public void clickQuestionButton (int index){
        driver.findElement(By.id(QUESTIONS_ARRAY[index])).click();
    }

    //Метод для получения текста элемента
        public static String getText(int index){
        String question ="accordion__heading-";
        String answer = "accordion__panel-";
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(QUESTIONS_ARRAY[index])));
        return driver.findElement(By.id(ANSWERS_ARRAY[index])).getText();
    }
}