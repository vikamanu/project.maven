package ru.geek.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LogIn {
    private static final String PAGE_URL = "https://kudago.com/msk/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications")
                .addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(PAGE_URL);
        driver.findElement(By.xpath("//div[@id='userzone']//a[contains(@class, 'login')]")).click();

        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']"))
                .sendKeys("vika-manu76@mail.ru");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']"))
                .sendKeys("manu76()");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']"))
                .click();

        Thread.sleep(5000);
        driver.quit();
    }
}
