package ru.manugeek;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.manugeek.home6.Crm6.LoginPage;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.manugeek.home6.KudaGo.Listeners.CustomLogger;

public class TestBase {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;

    @BeforeAll
    static void beforeAll() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpBrowser(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 10);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void closeBrowser(){
        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out :: println);
        driver.quit();
    }
}

