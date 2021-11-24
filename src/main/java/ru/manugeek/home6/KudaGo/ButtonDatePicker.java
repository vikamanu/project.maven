package ru.manugeek.home6.KudaGo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonDatePicker extends BasePage {
    public ButtonDatePicker(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='DayPicker-choosenDate navbar-item-link']")
    public WebElement dayPickerItem;

    @FindBy(xpath = "//div[@aria-label='пт 19 нояб. 2021 г.']")
    public WebElement chosenDate;

    @FindBy(xpath = "//button[@class='button']")
    public WebElement buttonChosenDate;

    @FindBy(xpath = "//div[@id='react-date-picker']")
    public WebElement successChosenDate;

    @Step("Нажать кнопку Выбор даты")
    public ButtonDatePicker clickDayPickerItem() {
        dayPickerItem.click();
        return this;
    }

    @Step("Выбрать дату")
    public ButtonDatePicker clickChosenDate() {
        chosenDate.click();
        return this;
    }

    @Step("Нажать кнопку Применить")
    public ButtonDatePicker clickButtonChosenDate() {
        buttonChosenDate.click();
        return this;
    }
}
