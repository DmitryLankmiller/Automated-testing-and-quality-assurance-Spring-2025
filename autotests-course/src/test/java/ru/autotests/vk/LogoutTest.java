package ru.autotests.vk;

import static com.codeborne.selenide.Condition.enabled;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LogoutTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("emailsAndPasswords")
    public void shouldFaileLoginWithIncorrectPassword(String email, String password) {
        var mainPage = new LoginPage().loginByEmail(email, password);
        var loginPage = mainPage.logout();
        loginPage.loginInput().shouldBe(enabled);
        loginPage.passwordInput().shouldBe(enabled);
    }

    private static Stream<Arguments> emailsAndPasswords() {
        return Stream.of(
                Arguments.of("technopol33", "technopolisPassword"));
    }
}
