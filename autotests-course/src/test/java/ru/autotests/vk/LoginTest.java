package ru.autotests.vk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.autotests.vk.pages.LoginPage;
import ru.autotests.vk.pages.MainPage;

public class LoginTest extends BaseTest {
    @ParameterizedTest
    @Tag("auth")
    @MethodSource("emailsPasswordsUsernames")
    public void shouldLoginByCorrectEmailAndPassword(String email, String password, String userName) {
        var loginPage = new LoginPage();
        loginPage.writeLogin(email);
        loginPage.writePassword(password);
        loginPage.clickLoginBtn();
        var mainPage = new MainPage();
        assertEquals(userName, mainPage.sideNavigation().getUserName());
    }

    private static Stream<Arguments> emailsPasswordsUsernames() {
        return Stream.of(
                Arguments.of("technopol33", "technopolisPassword", "technopol33 technopol33"),
                Arguments.of("technopol36", "technopolisPassword", "technopol36 technopol36"));
    }

}
