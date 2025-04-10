package ru.autotests.vk;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class MsgPage extends BasePage {
    private static final By msgApp = By.xpath(".//msg-app");
    private static final By msgInput = By.xpath(".//msg-input");
    private static final By sendMessageBtn = By.xpath(".//*[@role=\"toolbar\"]//*[@data-l=\"t,sendButton\"]");
    private static final By msgName = By.xpath(".//msg-name");
    private static final By msgMoreActionsBtn = By.xpath(".//*[@data-tsid=\"more_message\"]");
    private static final By msgActionRemoveBtn = By.xpath(".//*[@data-l=\"t,messageActionremove\"]");
    private static final By confirmDeleteBtn = By.xpath(".//*[@data-tsid=\"confirm-primary\"]");
    private static final By messages = By.xpath(".//*[@data-tsid=\"message_text\"]");
    private static final By chats = By.xpath(".//msg-chats-list-item");

    private static SelenideElement chatByUserName(String userName) {
        return $$(chats).findBy(text(userName));
    }

    @Override
    void checkPage() {
        $(msgApp).shouldBe(visible);
    }

    public MsgPage openChatByUserName(String userName) {
        chatByUserName(userName).click();
        return this;
    }

    public MsgPage messageInputShouldBeEnabled() {
        $(msgInput).shouldBe(clickable);
        return this;
    }

    public MsgPage chatNameShouldHaveText(String txt) {
        $(msgName).shouldHave(text(txt));
        return this;
    }

    public MsgPage writeMessage(String msg) {
        $(msgInput).sendKeys(msg);
        return this;
    }

    public MsgPage clickSendMessageBtn() {
        $(sendMessageBtn).click();
        return this;
    }

    public void lastMessageShouldHaveText(String txt) {
        $$(messages).last().shouldHave(text(txt));
    }

    public void deleteLastMessage() {
        $$(messages).last().hover();
        $(msgMoreActionsBtn).click();
        $(msgActionRemoveBtn).click();
        $(confirmDeleteBtn).click();
    }
}
