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
                {"Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {

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
