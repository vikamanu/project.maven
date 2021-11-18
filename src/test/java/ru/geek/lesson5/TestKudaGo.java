package ru.geek.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class TestKudaGo {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String PAGE_URL = "https://kudago.com/msk/";
    private static final String PAGE_URL_EVENT = "https://kudago.com/msk/events/";

    @BeforeTest
    void webDriverSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test(description = "Positive logIn")
    void LogIn() {
        driver.get(PAGE_URL);
        driver.findElement(By.xpath("//div[@id='userzone']//a[contains(@class, 'login')]")).click();
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']"))
                .sendKeys("vika-manu76@mail.ru");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']"))
                .sendKeys("manu76()");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']"))
                .click();
        List<WebElement> userZone = driver.findElements(
                By.xpath("//span[@class='user-zone-underline']"));
        assertThat(userZone.get(0), hasText("Вика Ману"));
        Assert.assertTrue(userZone.get(0).isDisplayed());
    }



    @Test(description = "Positive logOut")
    void LogOut() {
        driver.get(PAGE_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("sessionid");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("sessionid", "6a1600ed572fedecd573b6c2b90a22fe6392a410");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Actions actions = new Actions(driver);
        WebElement iconDropdown = driver.findElement(By.xpath("//div[@class='user-zone-above']/i"));
        actions.moveToElement(iconDropdown).perform();
        driver.findElement(By.xpath("//a[@href='/account/logout/?next=https://kudago.com/msk/']")).click();
        List<WebElement> accountLogin = driver.findElements(
                By.xpath("//div[@id='userzone']//a[@href='/account/login/'][1]//span[1]"));
        assertThat(accountLogin.get(0).getText(), containsString("Вход"));
        Assert.assertTrue(accountLogin.get(0).isDisplayed());

    }

    @Test
    void ButtonAddEvent() {
        driver.get(PAGE_URL_EVENT);
        List<WebElement> event = driver.findElements(
                By.xpath("//a[@href='https://kudago.com/pages/about/adv/']"));
        assertThat(event.get(0), hasText("+ Добавить событие"));

    }

    @Test
    void ButtonDatePicker() {
        driver.get(PAGE_URL_EVENT);
        driver.findElement(By.xpath("//div[@class='DayPicker-choosenDate navbar-item-link']")).click();
        driver.findElement(By.xpath("//div[@aria-label='чт 18 нояб. 2021 г.']")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();
        List<WebElement> datePicker = driver.findElements(
                By.xpath("//div[@id='react-date-picker']"));
        Assert.assertTrue(datePicker.get(0).isDisplayed());
        assertThat(datePicker.get(0).getText(), containsString("18 ноября"));
    }

    @Test
    void ButtonCitySelect() {
        driver.get(PAGE_URL);
        List<WebElement> citySelect = driver.findElements(
                By.xpath("//span[@class='city-select']"));
        Assert.assertTrue(citySelect.get(0).isDisplayed());
        assertThat(citySelect.get(0).getText(), containsString("Москва"));
    }
    @Test
    void CenteredContainer() {
        driver.get(PAGE_URL_EVENT);
        List <WebElement> centeredContainer = By.xpath("//div[@id='lower-nav']//div[@class='centered-container']").findElements(
                driver);
        assertThat(centeredContainer.get(0).findElement(By.xpath("//a[@href='https://kudago.com/msk/city-food/']//span")),
                hasText("ЕДА"));
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

}
