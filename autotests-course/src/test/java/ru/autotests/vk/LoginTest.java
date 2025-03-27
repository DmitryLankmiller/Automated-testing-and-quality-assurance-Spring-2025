package ru.autotests.vk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class LoginTest {
    @BeforeAll
    public static void initSelenide() {
        Configuration.baseUrl = BasePage.BASE_URL;
        Configuration.browser = "chrome";
        // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @ParameterizedTest
    @CsvSource({"ditch725@gmail.com,45Lbhtrnjh,Дмитрий Ланкмиллер"})
    public void shouldLoginByCorrectEmailAndPassword(String email, String password, String userName) {
        Selenide.open();
        var loginPage = new LoginPage();
        var mainPage = loginPage.loginByEmail(email, password);
        assertEquals(userName, mainPage.getUserName());
    }
}
