package edu.praktikum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

// проверяю переход с нижней кнопки Заказать на форму: Для кого самокат
public class TestButtonSecond {
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
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        // открыл страницу Яндекс. Самокат
        driver.get(mainPage.getURL());
        // принимаем куки
        mainPage.clickAcceptCookie();
        mainPage.scrollToQuestion();
        // кликнул по нижей кнопке: Заказать
        mainPage.clickOrderButtonSecond();
        // заполняем первую форму заказа
        orderFormPage.fillFormSecond();
        // заполняем вторую форму заказа
        aboutRentPage.forYouInformationSecond();

    }

    //закрыл страницу Яндекс самоката
    @After
    public void tearDown() {
        driver.quit();
    }
}


