package ru.autotests.vk;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.codeborne.selenide.Selenide;

public class SendMessageTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("user1user2")
    @Tag("msg")
    public void shouldSendMessage(
            String email1, String password1, String userName1,
            String email2, String password2, String userName2,
            String msg) {
        var mainPage = new LoginPage().loginByEmail(email1, password1);
        var msgPage1 = mainPage.clickMessageBtn();
        msgPage1.openChatByUserName(userName2);
        msgPage1.messageName().shouldHave(text(userName2));
        msgPage1.sendMessage(msg);
        msgPage1.lastMessage().shouldHave(text(msg));
        Selenide.closeWebDriver();
        Selenide.open("/");
        mainPage = new LoginPage().loginByEmail(email2, password2);
        var msgPage2 = mainPage.clickMessageBtn();
        msgPage2.openChatByUserName(userName1);
        assertAll(
                () -> msgPage2.messageName().shouldHave(text(userName1)),
                () -> msgPage2.lastMessage().shouldHave(text(msg)));
    }

    private static Stream<Arguments> user1user2() {
        return Stream.of(
                Arguments.of("technopol33", "technopolisPassword", "technopol33 technopol33",
                        "technopol36", "technopolisPassword", "technopol36 technopol36",
                        "Hello, world!"),
                Arguments.of("technopol36", "technopolisPassword", "technopol36 technopol36",
                        "technopol33", "technopolisPassword", "technopol33 technopol33",
                        "HJG*UH$W(*EICJ)(#WPFUWOISDKV  dfg)"));
    }
}
