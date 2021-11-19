package ru.geek.lesson6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geek.lesson6.KudaGo.LogIn;
import ru.geek.lesson6.KudaGo.LogOut;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import static ru.geek.lesson6.KudaGo.ConfigurationKuda.BASE_URL;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestsPositiveLoginAndLogOut extends TestBase {
    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void positiveLogin() {
        new LogIn(driver)
                .submitUserZone()
                .inputLoginLocator()
                .fillInputLogin("vika-manu76@mail.ru")
                .fillInputPassword("manu76()")
                .submitLogin();
        assertThat(new LogIn(driver).loginSuccess,isDisplayed());
    }
    @Test
    void positiveLogOut() {
        new LogOut(driver)
                .getCookie()
                .waitLoginLocator()
                .iconDropDownForLogOut()
                .clickForLogOut();
        assertThat(new LogOut(driver).successLogOut.getText(), containsString("Вход"));
    }
}

