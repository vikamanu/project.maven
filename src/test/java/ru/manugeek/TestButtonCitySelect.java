package ru.manugeek;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.manugeek.home6.KudaGo.ButtonCitySelect;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static ru.manugeek.home6.ConfigurationKuda.BASE_URL;

@Feature("Тестирование элемента Выбор города")
public class TestButtonCitySelect extends TestBase {
    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }
    @Test
    void checkButtonCitySelect() {
        new ButtonCitySelect(driver)
                .dropDownCitySelect()
                .clickCitySelect()
                .citySelect();
        assertThat(new ButtonCitySelect(driver).successCitySelect.getText(), containsString("в Москве"));
    }
}



