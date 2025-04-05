package ru.autotests.vk;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LogoutTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("emailsAndPasswords")
    @Tag("auth")
    @Tag("logout")
    public void shouldLogoutCorrectly(String email, String password) {
        var mainPage = new LoginPage().loginByEmail(email, password);
        var loginPage = mainPage
                .expandProfileDropdownMenu()
                .clickLogoutBtn()
                .confirmLogoutMenuShouldBeVisible()
                .confirmLogout();
        loginPage.loginInputShouldBeEnabled();
        loginPage.passwordInputShouldBeEnabled();
    }

    private static Stream<Arguments> emailsAndPasswords() {
        return Stream.of(
                Arguments.of("technopol33", "technopolisPassword"));
    }
}
