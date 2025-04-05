package ru.autotests.vk;

import static com.codeborne.selenide.Condition.clickable;
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
    private static final SelenideElement msgMoreActionsBtn = $x(".//*[@data-tsid=\"more_message\"]");
    private static final SelenideElement msgActionRemoveBtn = $x(".//*[@data-l=\"t,messageActionremove\"]");
    private static final SelenideElement confirmDeleteBtn = $x(".//*[@data-tsid=\"confirm-primary\"]");
    private static final ElementsCollection messages = $$x(".//*[@data-tsid=\"message_text\"]");
    private static final ElementsCollection chats = $$x(".//msg-chats-list-item");

    private static SelenideElement chatByUserName(String userName) {
        return chats.findBy(text(userName));
    }

    @Override
    void checkPage() {
        msgApp.shouldBe(visible);
    }

    public MsgPage openChatByUserName(String userName) {
        chatByUserName(userName).click();
        return this;
    }

    public MsgPage messageInputShouldBeEnabled() {
        msgInput.shouldBe(clickable);
        return this;
    }

    public MsgPage chatNameShouldHaveText(String txt) {
        msgName.shouldHave(text(txt));
        return this;
    }

    public MsgPage writeMessage(String msg) {
        msgInput.sendKeys(msg);
        return this;
    }

    public MsgPage clickSendMessageBtn() {
        sendMessageBtn.click();
        return this;
    }

    public void lastMessageShouldHaveText(String txt) {
        messages.last().shouldHave(text(txt));
    }

    public void deleteLastMessage() {
        messages.last().hover();
        msgMoreActionsBtn.click();
        msgActionRemoveBtn.click();
        confirmDeleteBtn.click();
    }
}
