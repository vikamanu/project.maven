package ru.geek.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LogOut {
    private static WebDriver driver;
    private static final String PAGE_URL = "https://kudago.com/msk/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications")
                .addArguments("--disable-popup-blocking");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        login();

        Actions actions = new Actions(driver);
        WebElement iconDropdown = driver.findElement(By.xpath("//div[@class='user-zone-above']/i"));
        actions.moveToElement(iconDropdown).perform();

        driver.findElement(By.xpath("//a[@href='/account/logout/?next=https://kudago.com/msk/']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
    private static void login() {
        driver.get(PAGE_URL);
        driver.findElement(By.xpath("//div[@id='userzone']//a[contains(@class, 'login')]")).click();

        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']"))
                .sendKeys("vika-manu76@mail.ru");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']"))
                .sendKeys("manu76()");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']"))
                .click();
    }
}
