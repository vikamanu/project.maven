package ru.geek.lesson6.Crm6;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement submitButton;

    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }
    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    public MainPage submitLogin() {
        submitButton.click();
        return new MainPage(driver);
    }
    public MainPage login(String login, String password){
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submitButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new MainPage(driver).geekBrainsHomeButtonLocator));
        return new MainPage(driver);
    }
}
