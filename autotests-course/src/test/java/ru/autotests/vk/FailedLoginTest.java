package ru.autotests.vk;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FailedLoginTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("emailsAndIncorrectPasswords")
    public void shouldFaileLoginWithIncorrectPassword(String email, String password, String expectedMessage) {
        var loginPage = new LoginPage();
        loginPage.writeLogin(email);
        loginPage.writePassword(password);
        loginPage.clickLoginBtn();
        loginPage.loginFailedMessage().shouldBe(visible);
        assertEquals(expectedMessage, loginPage.getLoginFailedMessageText());
    }

    private static Stream<Arguments> emailsAndIncorrectPasswords() {
        return Stream.of(
                Arguments.of("technopol33", "technopolisPassw", "Неправильно указан логин и/или пароль"),
                Arguments.of("technopol33", "gSF(*GhnKSLFDgh934)", "Неправильно указан логин и/или пароль"),
                Arguments.of("technopol33", "", "Введите пароль"));
    }
}
