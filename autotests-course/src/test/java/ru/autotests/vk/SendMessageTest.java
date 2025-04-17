package ru.autotests.vk;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.codeborne.selenide.Selenide;

import ru.autotests.vk.pages.LoginPage;
import ru.autotests.vk.steps.InitSteps;

public class SendMessageTest extends BaseTest {
        private final InitSteps initSteps = new InitSteps();

        private void deleteTestMessage(String email, String password, String userName) {
                Selenide.closeWebDriver();
                Selenide.open("/");
                var mainPage = new LoginPage().loginByEmail(email, password);
                var msgPage = mainPage.toolbar().clickMessageBtn();
                var chat = msgPage.msgMain().openChatByUserName(userName);
                chat.deleteLastMessage();
        }

        @ParameterizedTest
        @MethodSource("user1user2")
        @Tag("msg")
        public void shouldSendMessage(
                        String email1, String password1, String userName1,
                        String email2, String password2, String userName2,
                        String msg) {
                var mainPage = new LoginPage().loginByEmail(email1, password1);
                var msgPage1 = mainPage.toolbar().clickMessageBtn();
                var chat1 = msgPage1.openChatByUserName(userName2);
                chat1.writeMessage(msg)
                                .clickSendMessageBtn()
                                .lastMessageShouldHaveText(msg);
                initSteps.restartBrowser();
                mainPage = new LoginPage().loginByEmail(email2, password2);
                var msgPage2 = mainPage.toolbar().clickMessageBtn();
                var chat2 = msgPage2.openChatByUserName(userName1);
                chat2.lastMessageShouldHaveText(msg);
                deleteTestMessage(email1, password1, userName2);
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
