package ru.autotests.vk.elements.msg;

import static com.codeborne.selenide.Condition.text;

import org.openqa.selenium.By;

import ru.autotests.vk.elements.ElementWithRoot;

public class MsgChatsListElement extends ElementWithRoot {
    private static final By chatsListRoot = By.xpath(".//*[@data-tsid=\"chats_list_root\"]");
    private static final By chats = By.xpath(".//msg-chats-list-item");
    private MsgChatsListToolbarElement toolbar;

    public MsgChatsListElement() {
        super(chatsListRoot);
        toolbar = new MsgChatsListToolbarElement();
    }

    public MsgChatsListToolbarElement chatsToolbar() {
        return toolbar;
    }

    public MsgChatElement openChatByUserName(String userName) {
        elementsFromRoot(chats).findBy(text(userName));
        return new MsgChatElement();
    }

    public MsgMainElement openMsgMain() {
        return toolbar.openMsgMain();
    }

}