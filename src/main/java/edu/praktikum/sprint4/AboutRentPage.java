package edu.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {

    //добавил WebDriver
    public WebDriver driver;
    // выбор даты из списка
    private final By dateWhenBringScooter = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    //поле: срок аренды
    private final By dropDownPeriod = By.xpath(".//div[contains(text(),'Срок аренды')]");
    // выбираем период
    private final By dropPeriod = By.xpath(".//div[contains(text(),'сутки')]");
    // поле: цвет самоката
    private final By checkBoxColor = By.xpath(".//label[text()='чёрный жемчуг']");
    // поле: комментарий для курьера
    private final By commentForTheCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопка заказать под формой про аренду
    private final By orderButtonUnderForm = By.xpath("(.//button[contains(text(),'Заказать')])[2]");
    // кнопка: Да (popap: Хотите оформить заказ?)
    private final By buttonYes = By.xpath(".//button[text()='Да']");
    // путь до popap: Заказ оформлен
    private final By popapOrderPlaced = By.xpath(".//div[text()='Заказ оформлен']");

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод: дата ожидания самоката
    public void setDateScooterDelivery(String DateScooterDelivery) {
        driver.findElement(dateWhenBringScooter).sendKeys(DateScooterDelivery);
        driver.findElement(dateWhenBringScooter).sendKeys(Keys.ENTER);
    }
        // метод: срок аренды - кнопка выпадающего списока
        public void setDropDownPeriod() {
            driver.findElement(dropDownPeriod).click();
            driver.findElement(dropPeriod).click();
        }

        public void setCheckBoxColor () {
            driver.findElement(checkBoxColor).click();
        }
        // метод: комментарий для курьера
        public void setInfoForCourier(String InfoForCourier){
            driver.findElement(commentForTheCourier).sendKeys(InfoForCourier);
        }
        // нажал на кнопку: заказать под формой про аренду
        public void clickOrderButtonUnderForm(){
            driver.findElement(orderButtonUnderForm).click();
        }
    // метод: нажимающий на кнопку: Да (popap: Хотите оформить заказ?)
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }
    // метод popap: Заказ оформлен
    public String getPopapOrderPlaced() {
        String text = driver.findElement(popapOrderPlaced).getText();
        System.out.println(text);
        return text;
    }
        public void forYouInformationFirst(String DateScooterDelivery, String InfoForCourier){

            setDateScooterDelivery(DateScooterDelivery);
            setDropDownPeriod();
            setCheckBoxColor();
            setInfoForCourier(InfoForCourier);
            clickOrderButtonUnderForm();
            clickButtonYes();
        }

    public void forYouInformationSecond(){

        setDateScooterDelivery("29.11.2023");
        setDropDownPeriod();
        setCheckBoxColor();
        setInfoForCourier("Welcome");
        clickOrderButtonUnderForm();
        clickButtonYes();
    }
}
