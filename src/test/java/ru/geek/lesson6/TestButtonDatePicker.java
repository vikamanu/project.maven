package ru.geek.lesson6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geek.lesson6.KudaGo.ButtonDatePicker;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.geek.lesson6.KudaGo.ConfigurationKuda.EVENTS_URL;


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
