package ru.geek.lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.geek.lesson6.Crm6.ContactCreate;
import ru.geek.lesson6.Crm6.ContactsPage;
import ru.geek.lesson6.Crm6.LoginPage;
import ru.geek.lesson6.Crm6.PartnerSubMenu;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.geek.lesson6.Crm6.Configuration.*;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestContactCreating extends TestBase {
    @BeforeEach
    public void goToPage(){
        driver.get(BASE_URL);
    }

    @Test
    void createNewContact() {
        new LoginPage(driver).login(CRM_LOGIN, CRM_PASSWORD)
                .navigationMenu.openNavigationMenuItem("Контрагенты");
        new PartnerSubMenu(driver).goToPageContacts();
        new ContactsPage(driver).contactCreate();
        new ContactCreate(driver)
                .fillSurnameInput("Иванов")
                .fillNameInput("Иван")
                .fillOrganisationSearch("Все организации")
                .fillJobTitleInput("Тестер")
                .pushSaveAndCloseButton();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(new ContactCreate(driver).infoAboutSuccessSavingLocatorContact)));

        assertThat(new ContactCreate(driver).infoAboutSuccessSaving, isDisplayed());
    }
}
