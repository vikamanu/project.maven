package ru.manugeek;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.manugeek.home6.Crm6.AllProjectsPage;
import ru.manugeek.home6.Crm6.LoginPage;
import ru.manugeek.home6.Crm6.ProjectCreating;
import ru.manugeek.home6.Crm6.ProjectSubMenu;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.manugeek.Configuration.*;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


@Feature("Тестирование создания нового проекта")
public class TestProjectCreating extends TestBase {

    @BeforeEach
    public void goToPage(){
        driver.get(BASE_URL1);
    }

    @Test
    void createNewProject() {
        new LoginPage(driver).login(CRM_LOGIN, CRM_PASSWORD)
                .navigationMenu.openNavigationMenuItem("Проекты");
        new ProjectSubMenu(driver).goToPageAllProjects();
        new AllProjectsPage(driver).createProject();
        new ProjectCreating(driver)
                .fillProjectNameInput("testvika")
                .fillOrganisationSearch("Все орг")
                .selectBusinessUnitSelect("Research & Development")
                .selectProjectCurator("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectManager("Applanatest1 Applanatest1 Applanatest1")
                .selectManager("Applanatest1 Applanatest1 Applanatest1")
                .fillPlanningDescription("Планирование")
                .fillProjectRequirementsManagementDescription("Управление требованиями")
                .fillProjectDevelopmentDescription("Разработка")
                .fillTestingDescription("Тестирование")
                .fillConfigManagement("Управление конфигурацией")
                .saveAndCloseButton.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-overlay")));
        assertThat(new ProjectCreating(driver).infoAboutSuccessSaving, isDisplayed());
    }
}