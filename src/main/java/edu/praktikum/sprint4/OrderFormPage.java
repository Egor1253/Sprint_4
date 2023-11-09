package edu.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.awt.SystemColor.text;

public class OrderFormPage {

    //добавил WebDriver
    public WebDriver driver;
    // Форма заполнения страницы: для кого самокат
    private final By forHwoScooter = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']");
    // поле: Имя
    private final By userName = By.xpath(".//div[@class='Input_InputContainer__3NykH'][2]/../div/input[@placeholder='* Имя']");
    // поле: Фамилия
    private final By userSurname = By.xpath(".//div[@class='Input_InputContainer__3NykH'][2]/input[@placeholder='* Фамилия']");
    // поле: Адрес куда привезти заказ
    private final By userAddress = By.xpath(".//div[@class='Input_InputContainer__3NykH'][3]/input[@placeholder='* Адрес: куда привезти заказ']");
    // клик для открытия списка станций метро
    private final By metroStationButten = By.xpath(".//div[@class='select-search']");
    // выбор станции метро
    private final By userMetroStation = By.xpath(".//div//ul/li[2]");
    // поле: Телефон: на него позвонит курьер
    private final By userPhoneNumber = By.xpath(".//div[@class='Input_InputContainer__3NykH'][4]/input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод перехода на форму заказа самоката (название: Для кого самокат)
    public String getForHwoScooterPage() {
        return driver.findElement(forHwoScooter).getText();

    }

    // метод заполнения поля имя
    public void setName(String name) {
        driver.findElement(userName).sendKeys(name);
    }

    // метод заполнения поля фамилия
    public void setSurname(String surname) {
        driver.findElement(userSurname).sendKeys(surname);
    }

    // метод заполнения поля адрес
    public void setAddress(String address) {
        driver.findElement(userAddress).sendKeys(address);
    }

    // метод открытия списка названий станций метро
    public void clickMetroStationButton() {
        driver.findElement(metroStationButten).click();
    }
        // метод заполнения поля станция метро
        public void setMetroStation() {
            driver.findElement(userMetroStation).click();
        }
        // метод заполнения поля телефон
        public void setPhoneNumber (String phoneNumber){
            driver.findElement(userPhoneNumber).sendKeys(phoneNumber);
        }
        // метод: клик по кнопке далее
        public void clickNextButton () {
                driver.findElement(nextButton).click();
            }
        // метод объединяющий поля ввода формы заказа и кнопку далее
        public void fillFormFirst(String name, String surname, String address, String phoneNumber){
            setName(name);
            setSurname(surname);
            setAddress(address);
            clickMetroStationButton();
            setMetroStation();
            setPhoneNumber(phoneNumber);
            clickNextButton();
        }


}

