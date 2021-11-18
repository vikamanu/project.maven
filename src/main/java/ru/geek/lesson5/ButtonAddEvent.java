package ru.geek.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ButtonAddEvent {
    private static final String PAGE_URL = "https://kudago.com/msk/events/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(PAGE_URL);
        driver.findElement(By.xpath("//a[@href='https://kudago.com/pages/about/adv/']")).click();
        driver.findElement(By.xpath("//a[@href='#popup:price3']")).click();


        Thread.sleep(5000);
        driver.quit();
    }
}
