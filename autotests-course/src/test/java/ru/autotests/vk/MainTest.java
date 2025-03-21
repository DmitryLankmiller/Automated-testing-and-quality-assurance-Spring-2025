package ru.autotests.vk;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shoudCheckSelenideAvailable() {
        Selenide.open("https://ok.ru/");
        $(By.id("field_email")).setValue("example@mail.ru");
        $("#field_email").shouldBe(visible);
    }
}
