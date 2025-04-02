package ru.autotests.vk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
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

    @ParameterizedTest
    @CsvSource({ "technopol33,technopolisPassword,technopol33 technopol33" })
    public void shouldLoginByCorrectEmailAndPassword(String email, String password, String userName) {
        var loginPage = new LoginPage();
        var mainPage = loginPage.loginByEmail(email, password);
        assertEquals(userName, mainPage.getUserName());
    }
}
