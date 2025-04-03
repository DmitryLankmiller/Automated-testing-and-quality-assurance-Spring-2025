package ru.autotests.vk;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class MsgPage extends BasePage {
    private static final SelenideElement msgApp = $x(".//msg-app");
    private static final SelenideElement msgInput = $x(".//msg-input");
    private static final SelenideElement msgName = $x(".//msg-name");
    private static final ElementsCollection chats = $$x(".//msg-chats-list-item");

    private static SelenideElement chatByUserName(String userName) {
        return chats.findBy(text(userName));
    }

    @Override
    void checkPage() {
        msgApp.shouldBe(visible);
    }

    public void openChatByUserName(String userName) {
        chatByUserName(userName).click();
    }

    public SelenideElement messageInput() {
        return msgInput;
    }

    public SelenideElement messageName() {
        return msgName;
    }

}
