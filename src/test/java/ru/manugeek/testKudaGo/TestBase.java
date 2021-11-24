package ru.manugeek.testKudaGo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.manugeek.home6.KudaGo.ButtonDatePicker;
import ru.manugeek.home6.KudaGo.Listeners.CustomLogger;
import ru.manugeek.home6.KudaGo.LogIn;
import ru.manugeek.home6.KudaGo.LogOut;

public class TestBase {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;
    LogIn logIn;
    LogOut logOut;
    ButtonDatePicker buttonDatePicker;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 15);
        logIn = new LogIn(driver);
        logOut = new LogOut(driver);
        buttonDatePicker = new ButtonDatePicker(driver);
    }

    @AfterEach
    void tearDown(){
        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        driver.quit();
    }
}

