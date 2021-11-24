package ru.manugeek.home6.Crm6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BaseView {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title = 'Создать контактное лицо']")
    public WebElement createContactButton;

    public By createContactButtonLocator = By.xpath("//a[@title = 'Создать контактное лицо']");

    public void contactCreate(){
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new ContactCreate(driver).surnameInputLocator));
    }
}

