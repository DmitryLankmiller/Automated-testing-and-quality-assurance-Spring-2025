package ru.autotests.vk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    @BeforeAll
    public static void initSelenide() {
        Configuration.baseUrl = BasePage.BASE_URL;
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        Selenide.open("/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
