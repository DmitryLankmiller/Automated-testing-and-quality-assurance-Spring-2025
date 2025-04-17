package ru.autotests.vk;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.autotests.vk.pages.LoginPage;
import ru.autotests.vk.steps.DeleteMessageSteps;
import ru.autotests.vk.steps.InitSteps;

public class DeleteMessageTest extends BaseTest {
        private static final String WELCOME_CHAT_PHRASE = "В этом чате нет новых сообщений.\r\nВаше может быть первым!";
        private final InitSteps initSteps = new InitSteps();
        private final DeleteMessageSteps deleteMessageSteps = new DeleteMessageSteps();

        @ParameterizedTest
        @MethodSource("user1user2")
        @Tag("msg")
        public void shouldDeleteMessage(
                        String email1, String password1, String userName1,
                        String email2, String password2, String userName2,
                        String msg) {
                var mainPage = new LoginPage().loginByEmail(email1, password1);
                var msgPage1 = mainPage.toolbar().clickMessageBtn();
                var chat1 = msgPage1.openChatByUserName(userName2);
                chat1.welcomeChatShouldHaveText(WELCOME_CHAT_PHRASE)
                                .writeMessage(msg)
                                .clickSendMessageBtn();
                chat1.lastMessageShouldHaveText(msg);
                deleteMessageSteps.deleteLastMessageInChat(chat1);
                chat1.welcomeChatShouldHaveText(WELCOME_CHAT_PHRASE);
                initSteps.restartBrowser();
                mainPage = new LoginPage().loginByEmail(email2, password2);
                var msgPage2 = mainPage.toolbar().clickMessageBtn();
                var chat2 = msgPage2.openChatByUserName(userName1);
                chat2.welcomeChatShouldHaveText(WELCOME_CHAT_PHRASE);
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
