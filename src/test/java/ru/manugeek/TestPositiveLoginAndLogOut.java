package ru.manugeek;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.manugeek.home6.KudaGo.LogIn;
import ru.manugeek.home6.KudaGo.LogOut;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.manugeek.home6.ConfigurationKuda.BASE_URL;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Feature("Тестирование позитивного сценария LogIn и LogOut")
public class TestPositiveLoginAndLogOut extends TestBase {
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
