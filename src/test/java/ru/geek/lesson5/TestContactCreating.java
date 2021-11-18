package ru.geek.lesson5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class TestContactCreating {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeTest
    void webDriverSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
        login();
    }

    @Test(description = "Создание нового контактного лица в CRM")
    void ContactCreat() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"))).perform();

        driver.findElement(By.xpath("//li[@data-route = 'crm_contact_index']/a")).click();

        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Супертест");

        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Тест");

        driver.findElement(By.xpath("//span[@class = 'select2-arrow']")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(("Все " +
                "организации"));
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("1234");



        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);

        List<WebElement> contactSave = driver.findElements(
                By.xpath("//*[text()='Контактное лицо сохранено']"));
        assertThat(contactSave.get(0), hasText("Контактное лицо сохранено"));

    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    private void login(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}