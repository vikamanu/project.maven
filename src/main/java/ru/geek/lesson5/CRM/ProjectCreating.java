package ru.geek.lesson5.CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProjectCreating {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        login();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"))).perform();

        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();

        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        driver.findElement(By.name("crm_project[name]")).sendKeys("Проект проектов12");

        driver.findElement(By.xpath("//span[@class='select2-arrow']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");

        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select projectManager = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectManager.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select mainContact = new Select(driver.findElement(By.name("crm_project[contactMain]")));
        mainContact.selectByVisibleText("1 1");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Запланировали");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'project_requirementsManagement')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Требования");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_development-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Разработка");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'testing')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Тестирование");
        driver.switchTo().defaultContent();

        driver.findElement(By.name("crm_project[configManagement]")).click();
        driver.findElement(By.name("crm_project[configManagement]")).sendKeys("Управление конфигур");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));

        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));

        Thread.sleep(5000);
        driver.close();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
