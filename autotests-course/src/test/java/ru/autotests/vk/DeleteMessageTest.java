package ru.autotests.vk;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.autotests.vk.pages.LoginPage;

public class DeleteMessageTest extends BaseTest {
        private static final String WELCOME_CHAT_PHRASE = "В этом чате нет новых сообщений.\r\nВаше может быть первым!";

        @ParameterizedTest
        @MethodSource("user1user2")
        @Tag("msg")
        public void shouldDeleteMessage(
                        String email1, String password1, String userName1,
                        String email2, String password2, String userName2,
                        String msg) {
                var mainPage = new LoginPage().loginByEmail(email1, password1);
                var msgPage1 = mainPage.toolbar().clickMessageBtn();
                msgPage1.openChatByUserName(userName2)
                                .welcomeChatShouldHaveText(WELCOME_CHAT_PHRASE)
                                .writeMessage(msg)
                                .clickSendMessageBtn()
                                .lastMessageShouldHaveText(msg);
                msgPage1.hoverLastMessage()
                                .clickMessageMoreActionsBtn()
                                .clickDeleteMessageBtn()
                                .clickConfirmDeleteBtn()
                                .welcomeChatShouldHaveText(WELCOME_CHAT_PHRASE);
                restartBrowser();
                mainPage = new LoginPage().loginByEmail(email2, password2);
                var msgPage2 = mainPage.toolbar().clickMessageBtn();
                msgPage2.openChatByUserName(userName1)
                                .welcomeChatShouldHaveText(WELCOME_CHAT_PHRASE);
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
