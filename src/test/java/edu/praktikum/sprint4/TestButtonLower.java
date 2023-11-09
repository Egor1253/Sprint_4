package edu.praktikum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static java.awt.SystemColor.text;
import static org.junit.Assert.assertEquals;

// проверяю переход с нижней кнопки Заказать на форму: Для кого самокат
public class TestButtonLower {
    //добавил WebDriver
    public WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void orderSecond() {
        // переход на страницу тестового приложения
        MainPage mainPage = new MainPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        // открыл страницу Яндекс. Самокат
        driver.get(mainPage.getURL());
        // принимаем куки
        mainPage.clickAcceptCookie();
        // прокручиваю страницу до нижней кнопки заказать
        mainPage.scrollToQuestion();
        // кликнул по нижей кнопке: Заказать
        mainPage.clickOrderButtonSecond();
        // проверил название формы: Для кого самокат
        String ExpectedText = "Для кого самокат";
        // получил переход на форму заказа самоката
        String ActualPage = orderFormPage.getForHwoScooterPage();
        assertEquals("Нет получен текст: Для кого самокат", ExpectedText, ActualPage);
    }

    //закрыл страницу Яндекс самоката
    @After
    public void tearDown() {
        driver.quit();
    }
}


