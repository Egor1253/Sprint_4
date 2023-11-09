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
//класс с параметризованным автотестом: проверка первой кнопки
public class TestButtonUpper {

    // добавил WebDriver
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String day;
    private final String period;
    private final String color;
    private final String comment;

    public TestButtonUpper(String name, String surname, String address, String metroStation, String phoneNumber,
                           String day, String period, String color, String comment) {

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.day = day;
        this.period = period;
        this.color = color;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getInfo() {
        return new Object[][]{
                {"Михаил", "Бондарчук", "Москва, ул. Луговая, д.27, кв.17", "Сокол", "+79160000000", "27.11.2023", "сутки", "black", "Сегодня приедете?"},
                {"Маша", "Шашкина", "Москва, ул. Радужная, д.27, кв.102", "Аннино", "+79160000001", "28.11.2023", "сутки", "black", "Пожалуйста, позвоните за час до времени доставки!"},
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
    public void orderFirst() {

        MainPage mainPage = new MainPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        // открыл страницу
        driver.get(mainPage.getURL());
        System.out.println(driver.getCurrentUrl());
        // принимаем куки
        mainPage.clickAcceptCookie();
        // нажал на первую кнопку: Заказать (вверху главной страницы)
        mainPage.clickOrderButtonFirst();
        // заполнил форму заказа
        orderFormPage.fillFormFirst(name, surname, address, phoneNumber);
        // заполнил информация для доставки
        aboutRentPage.forYouInformationFirst(day, comment);
        // проверил наличие всплывающего окна об успешном создании заказа
        String popapOrderPlaced = aboutRentPage.getPopapOrderPlaced();
        String expected = "Заказ оформлен";
        Assert.assertEquals("Окно с сообщением об успешном создании заказа не появилось", expected, popapOrderPlaced);
    }
        //закрыл страницу Яндекс самоката
        @After
    public void tearDown() {
      driver.quit();
    }
}


