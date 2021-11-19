package ru.geek.lesson6.KudaGo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonCitySelect extends BasePage {
    public ButtonCitySelect(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='city-select']")
    public WebElement iconCitySelect;

    @FindBy(xpath = "//ul[@id='locations-dropdown']//a[@href='/spb/']")
    public WebElement citySelect;

    @FindBy(xpath = "//div[@class='location-switcher']/span")
    public WebElement successCitySelect;

    public ButtonCitySelect dropDownCitySelect(){
        Actions actions = new Actions(driver);
        actions.moveToElement(iconCitySelect).perform();
        return this;
    }
    public ButtonCitySelect clickCitySelect(){
        iconCitySelect.click();
        return this;
    }

    public void citySelect(){
        citySelect.click();
    }
}
