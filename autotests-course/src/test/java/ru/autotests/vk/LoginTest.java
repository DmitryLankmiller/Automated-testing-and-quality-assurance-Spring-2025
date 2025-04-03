package ru.autotests.vk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest {
    @ParameterizedTest
    @Tag("auth")
    @CsvSource({ "technopol33,technopolisPassword,technopol33 technopol33" })
    public void shouldLoginByCorrectEmailAndPassword(String email, String password, String userName) {
        var loginPage = new LoginPage();
        var mainPage = loginPage.loginByEmail(email, password);
        assertEquals(userName, mainPage.getUserName());
    }
}
