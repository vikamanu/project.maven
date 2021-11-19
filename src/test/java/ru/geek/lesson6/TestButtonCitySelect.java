package ru.geek.lesson6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geek.lesson6.KudaGo.ButtonCitySelect;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static ru.geek.lesson6.KudaGo.ConfigurationKuda.BASE_URL;


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
