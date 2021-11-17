package ru.geek.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class SeleniumDevStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Вика\\IdeaProjects\\new.project.maven\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        sleep(Long.parseLong("5000"));
        driver.quit();

        WebDriverManager.firefoxdriver().setup();
        WebDriver ffDriver=new FirefoxDriver();
        ffDriver.get("https://ya.ru");
        sleep(Long.parseLong("5000"));
        driver.quit();


    }
}
