package ru.geek.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CrmContactTest {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        login();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"))).perform();

        driver.findElement(By.xpath("//li[@data-route = 'crm_contact_index']/a")).click();

        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Тест");

        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("ТестТест");

        driver.findElement(By.xpath("//span[@class ='select2-arrow']")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Тестирует");
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));

        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));

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
