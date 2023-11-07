package edu.praktikum.sprint4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


@RunWith(Parameterized.class)


//класс с автотестом: Разговоры о важном.
public class СheckAnswers {
    private WebDriver driver;
    private String question;
    private String expectedAnswer;
    public СheckAnswers(String question, String expectedAnswer) {

        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}
        };
    }

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void checkAnswersToQuestions() {


        MainPage mainPage = new MainPage(driver);
        // открыл страницу
        driver.get(mainPage.getURL());
        System.out.println(driver.getCurrentUrl());
        // прокрутил страницу до блока разговоры о важном.
        mainPage.scrollToQuestion();
        // кликнул по кнопке вопроса: Сколько стоит?
        mainPage.clickQuestionByText(question);
        // проверил наличие ответа
        String activeAnswer = mainPage.getActiveAnswerText();
        // проверяем, верен ли ответ
        Assert.assertEquals("Текст не совпал!", expectedAnswer, activeAnswer);

    }

    // закрыл страницу Яндекс самокат.
    @After
    public void tearDown() {
        driver.quit();
    }
}
