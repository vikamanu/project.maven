package ru.geek.lesson6.Crm6;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProjectCreating extends BaseView {

    public ProjectCreating(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectNameInput;
    public  By projectNameInputLocator = By.name("crm_project[name]");

    public ProjectCreating fillProjectNameInput(String projectName) {
        projectNameInput.sendKeys(projectName);
        return this;
    }

    @FindBy(xpath = "//span[@class='select2-arrow']/..")
    public WebElement OrganisationNameSearch;
    public By OrganisationNameSearchLocator = By.xpath("//span[@class='select2-arrow']/..");

    public ProjectCreating fillOrganisationSearch(String organisationName) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-overlay")));
        OrganisationNameSearch.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='\"Континент+\"']")));
        OrganisationNameSearch.sendKeys(organisationName);
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Все орг')]")));
        OrganisationNameSearch.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    public ProjectCreating selectBusinessUnitSelect(String businessUnitName) {
        new Select (businessUnitSelect).selectByVisibleText(businessUnitName);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement projectCurator;

    public ProjectCreating selectProjectCurator(String projectCuratorName) {
        new Select (projectCurator).selectByVisibleText(projectCuratorName);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement projectManager;

    public ProjectCreating selectProjectManager(String projectManagerName) {
        new Select (projectManager).selectByVisibleText(projectManagerName);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement manager;

    public ProjectCreating selectManager(String managerName) {
        new Select (manager).selectByVisibleText(managerName);
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'planning')]")
    public WebElement framePlanning;


    @FindBy(xpath = "//body")
    public WebElement planningDescription;

    public ProjectCreating fillPlanningDescription(String planningDescriptionsText) {
        driver.switchTo().frame(framePlanning);
        planningDescription.sendKeys(planningDescriptionsText);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'project_requirementsManagement')]")
    public WebElement frameProjectRequirementsManagement;

    @FindBy(xpath = "//body")
    public WebElement projectRequirementsManagementDescription;

    public ProjectCreating fillProjectRequirementsManagementDescription(String projectRequirementsManagementDescriptionText) {
        driver.switchTo().frame(frameProjectRequirementsManagement);
        projectRequirementsManagementDescription.sendKeys(projectRequirementsManagementDescriptionText);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_development-uid')]")
    public WebElement frameProjectDevelopment;

    @FindBy(xpath = "//body")
    public WebElement projectDevelopmentDescription;

    public ProjectCreating fillProjectDevelopmentDescription(String projectDevelopmentDescriptionText) {
        driver.switchTo().frame(frameProjectDevelopment);
        projectDevelopmentDescription.sendKeys(projectDevelopmentDescriptionText);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'testing')]")
    public WebElement frameTesting;

    @FindBy(xpath = "//body")
    public WebElement testingDescription;

    public ProjectCreating fillTestingDescription(String testingDescriptionText) {
        driver.switchTo().frame(frameTesting);
        testingDescription.sendKeys(testingDescriptionText);
        driver.switchTo().defaultContent();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("select2-drop-mask")));
        return this;
    }

    @FindBy(name = "crm_project[configManagement]")
    public WebElement configManagement;

    public ProjectCreating fillConfigManagement(String configManagementText) {
        configManagement.click();
        configManagement.sendKeys(configManagementText);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = infoAboutSuccessSavingLocatorProject)
    public WebElement infoAboutSuccessSaving;

    public static final String infoAboutSuccessSavingLocatorProject = "//*[text()='Проект сохранен']";
}
