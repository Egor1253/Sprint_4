package edu.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    // добавил WebDriver
    public WebDriver driver;
    // указал ссылку на сайт: Яндекс Самокат
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    // локатор до куки
    private final By acceptCookie = By.xpath(".//button[text()='да все привыкли']");
    // указал путь вопроса: разговоры о важном.
    private String questionLocator = ".//div[@class='accordion__item']//div[text()='%s']";
    //указал путь до ответа: разговоры о важном
    private final By activeAnswer = By.xpath(".//div[@class='accordion__item']//div[@aria-expanded='true']/../../div[@class='accordion__panel']");
    // верхняя кнопка заказать
    private static final By orderButtonFirst = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    // нижняя кнопка заказать
    private static final By orderButtonSecond = By.xpath("(.//button[text()='Заказать'])[2]");

    // конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод URL
    public String getURL() {
        return URL;}
    // принимаем куки
    public void clickAcceptCookie() {
        driver.findElement(acceptCookie).click();
    }
    // метод прокрутки страницы
    public void scrollToQuestion() {
        WebElement blockElement = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", blockElement);
    }
    //метод для нажатия кнопки с вопросом: Сколько стоит?
    public void clickQuestionByText(String text) {
        driver.findElement(By.xpath(String.format(questionLocator, text))).click();
    }
    //  метод ответа на вопрос?
    public String getActiveAnswerText() {
        return driver.findElement(activeAnswer).getText();
    }

    // метод: клик по верхней кнопке заказать
    public void clickOrderButtonFirst() {
        driver.findElement(orderButtonFirst).click();
    }
    // метод: клик по нижней кнопке заказать
    public void clickOrderButtonSecond() {
        driver.findElement(orderButtonSecond).click();
    }

}
