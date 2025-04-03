package ru.autotests.vk;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class MsgPage extends BasePage {
    private static final SelenideElement msgApp = $x(".//msg-app");
    private static final SelenideElement msgInput = $x(".//msg-input");
    private static final SelenideElement sendMessageBtn = $x(".//*[@role=\"toolbar\"]//*[@data-l=\"t,sendButton\"]");
    private static final SelenideElement msgName = $x(".//msg-name");
    private static final ElementsCollection messages = $$x(".//*[@data-tsid=\"message_text\"]");
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

    public void messageInputShouldBeEnabled() {
        msgInput.shouldBe(enabled);
    }

    public void messageNameShouldHaveText(String txt) {
        msgName.shouldHave(text(txt));
    }

    public void writeMessage(String msg) {
        msgInput.sendKeys(msg);
    }

    public void clickSendMessage() {
        sendMessageBtn.click();
    }

    public void sendMessage(String msg) {
        writeMessage(msg);
        clickSendMessage();
    }

    public ElementsCollection messages() {
        return messages;
    }

    public SelenideElement lastMessageShouldHaveText(String txt) {
        return messages.last().shouldHave(text(txt));
    }

    public SelenideElement nthMessage(int nth) {
        return messages.get(nth);
    }

}
