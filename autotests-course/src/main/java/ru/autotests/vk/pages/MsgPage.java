package ru.autotests.vk.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import ru.autotests.vk.elements.msg.MsgChatElement;
import ru.autotests.vk.elements.msg.MsgChatsListElement;
import ru.autotests.vk.elements.msg.MsgMainElement;

public class MsgPage extends BasePage {
    private static final By msgApp = By.xpath(".//msg-app");
    private MsgMainElement msgMain;
    private MsgChatElement chat;
    private MsgChatsListElement chatsList;

    public MsgPage() {
        this.msgMain = new MsgMainElement();
        this.chatsList = new MsgChatsListElement();
    }

    @Override
    void checkPage() {
        $(msgApp).shouldBe(visible);
    }

    public MsgMainElement msgMain() {
        return this.msgMain;
    }

    public MsgMainElement openMsgMain() {
        this.msgMain = chatsList.openMsgMain();
        return this.msgMain;
    }

    public MsgChatElement chat() {
        return this.chat;
    }

    public MsgChatElement openChatByUserName(String userName) {
        return this.msgMain.openChatByUserName(userName);
    }
}
