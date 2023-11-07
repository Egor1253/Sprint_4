package edu.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFormPage {

    //добавил WebDriver
    public WebDriver driver;
    // Форма заполнения страницы: для кого самокат
    private final By ForHwoScooter = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']");
    // поле: Имя
    private final By UserName = By.xpath(".//div[@class='Input_InputContainer__3NykH'][2]/../div/input[@placeholder='* Имя']");
    // поле: Фамилия
    private final By UserSurname = By.xpath(".//div[@class='Input_InputContainer__3NykH'][2]/input[@placeholder='* Фамилия']");
    // поле: Адрес куда привезти заказ
    private final By UserAddress = By.xpath(".//div[@class='Input_InputContainer__3NykH'][3]/input[@placeholder='* Адрес: куда привезти заказ']");
    // клик для открытия списка станций метро
    private final By MetroStationButten = By.xpath(".//div[@class='select-search']");
    // выбор станции метро
    private final By UserMetroStation = By.xpath(".//div//ul/li[2]");
    // поле: Телефон: на него позвонит курьер
    private final By UserPhoneNumber = By.xpath(".//div[@class='Input_InputContainer__3NykH'][4]/input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    //
    public String getForHwoScooterPage() {
        return driver.findElement(ForHwoScooter).getText();
    }

    // метод заполнения поля имя
    public void setName(String name) {
        driver.findElement(UserName).sendKeys(name);
    }

    // метод заполнения поля фамилия
    public void setSurname(String surname) {
        driver.findElement(UserSurname).sendKeys(surname);
    }

    // метод заполнения поля адрес
    public void setAddress(String address) {
        driver.findElement(UserAddress).sendKeys(address);
    }

    // метод открытия списка названий станций метро
    public void clickMetroStationButton() {
        driver.findElement(MetroStationButten).click();
    }
        // метод заполнения поля станция метро
        public void setMetroStation() {
            driver.findElement(UserMetroStation).click();
        }
        // метод заполнения поля телефон
        public void setPhoneNumber (String phoneNumber){
            driver.findElement(UserPhoneNumber).sendKeys(phoneNumber);
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

    public void fillFormSecond(){
        setName("Иван");
        setSurname("Тимофеев");
        setAddress("Москва, ул.Левая, д.6, кв.77");
        clickMetroStationButton();
        setMetroStation();
        setPhoneNumber("+791607788999");
        clickNextButton();
    }


}

