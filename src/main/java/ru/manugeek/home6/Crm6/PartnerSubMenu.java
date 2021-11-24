package ru.manugeek.home6.Crm6;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PartnerSubMenu extends BaseView {
    public PartnerSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text() = 'Контактные лица']/ancestor :: a")
    public WebElement ContactsButton;

    public void goToPageContacts(){
        ContactsButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new ContactsPage(driver).createContactButtonLocator));
    }
}

