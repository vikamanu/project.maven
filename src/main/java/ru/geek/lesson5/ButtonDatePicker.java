package ru.geek.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ButtonDatePicker {
    private static final String PAGE_URL = "https://kudago.com/msk/events/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications")
                .addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(PAGE_URL);
        driver.findElement(By.xpath("//div[@class='DayPicker-choosenDate navbar-item-link']")).click();
        driver.findElement(By.xpath("//div[@aria-label='чт 18 нояб. 2021 г.']")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
