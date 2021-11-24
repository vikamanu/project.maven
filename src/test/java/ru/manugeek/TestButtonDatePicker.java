package ru.manugeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.manugeek.home6.KudaGo.ButtonDatePicker;
import io.qameta.allure.Feature;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.manugeek.home6.ConfigurationKuda.EVENTS_URL;

@Feature("Тестирование элемента Выбор даты")
public class TestButtonDatePicker extends TestBase {
    @BeforeEach
    public void goToPage() {
        driver.get(EVENTS_URL);
    }
    @Test
    void checkButtonDatePicker() {
        new ButtonDatePicker(driver)
                .clickDayPickerItem()
                .clickChosenDate()
                .clickButtonChosenDate();
        assertThat(new ButtonDatePicker(driver).successChosenDate.getText(), containsString("19 ноября"));
    }
}
