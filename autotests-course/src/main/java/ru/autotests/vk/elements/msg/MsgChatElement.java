package ru.autotests.vk.elements.msg;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import org.openqa.selenium.By;

import ru.autotests.vk.elements.ElementWithRoot;

public class MsgChatElement extends ElementWithRoot {
    private static final By chatMain = By.xpath(".//*[@data-tsid=\"chat_main\"]");
    private static final By msgInput = By.xpath(".//msg-input");
    private static final By sendMessageBtn = By.xpath(".//*[@role=\"toolbar\"]//*[@data-l=\"t,sendButton\"]");
    private static final By msgName = By.xpath(".//msg-name");
    private static final By msgMoreActionsBtn = By.xpath(".//*[@data-tsid=\"more_message\"]");
    private static final By msgActionRemoveBtn = By.xpath(".//*[@data-l=\"t,messageActionremove\"]");
    private static final By messages = By.xpath(".//*[@data-tsid=\"message_text\"]");
    private static final By welcomeChatText = By.xpath(".//*[@class=\"welcome-chat-text-okmsg\"]");

    public MsgChatElement() {
        super(chatMain);
    }

    public MsgChatElement messageInputShouldBeEnabled() {
        elementFromRoot(msgInput).shouldBe(clickable);
        return this;
    }

    public MsgChatElement chatNameShouldHaveText(String txt) {
        elementFromRoot(msgName).shouldHave(text(txt));
        return this;
    }

    public MsgChatElement writeMessage(String msg) {
        elementFromRoot(msgInput).sendKeys(msg);
        return this;
    }

    public MsgChatElement clickSendMessageBtn() {
        elementFromRoot(sendMessageBtn).click();
        return this;
    }

    public MsgChatElement lastMessageShouldHaveText(String txt) {
        elementsFromRoot(messages).last().shouldHave(text(txt));
        return this;
    }

    public MsgChatElement lastMessageShouldBeVisible() {
        elementsFromRoot(messages).last().shouldBe(visible);
        return this;
    }

    public MsgChatElement hoverLastMessage() {
        elementsFromRoot(messages).last().hover();
        return this;
    }

    public MsgChatElement clickMessageMoreActionsBtn() {
        elementFromRoot(msgMoreActionsBtn).click();
        return this;
    }

    public MsgConfirmDeleteMessageElement clickDeleteMessageBtn() {
        elementFromRoot(msgActionRemoveBtn).click();
        return new MsgConfirmDeleteMessageElement();
    }

    public void deleteLastMessage() {
    }

    public MsgChatElement welcomeChatShouldHaveText(String text) {
        elementFromRoot(welcomeChatText).shouldHave(text(text));
        return this;
    }

}
