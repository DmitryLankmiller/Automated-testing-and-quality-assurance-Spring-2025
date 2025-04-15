package ru.autotests.vk;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.autotests.vk.pages.LoginPage;

public class OpenChatTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("emailPasswordFriend")
    @Tag("msg")
    public void shouldOpenChat(String email, String password, String friendName) {
        var mainPage = new LoginPage().loginByEmail(email, password);
        var msgPage = mainPage.toolbar().clickMessageBtn();
        msgPage.openChatByUserName(friendName);
        assertAll(
                "Chat has openned",
                () -> msgPage.messageInputShouldBeEnabled(),
                () -> msgPage.chatNameShouldHaveText(friendName));

    }

    private static Stream<Arguments> emailPasswordFriend() {
        return Stream.of(
                Arguments.of("technopol33", "technopolisPassword", "technopol36 technopol36"),
                Arguments.of("technopol36", "technopolisPassword", "technopol33 technopol33"));
    }
}
