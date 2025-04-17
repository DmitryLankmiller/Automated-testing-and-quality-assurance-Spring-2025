package ru.autotests.vk.elements.msg;

import org.openqa.selenium.By;

import ru.autotests.vk.elements.ElementWithRoot;

public class MsgChatsListToolbarElement extends ElementWithRoot {
    private static final By chatsListToolbar = By.xpath(".//*[@data-tsid=\"conversation_list_top_panel\"]");
    private static final By msgMainBtn = By.xpath(".//*[@data-tsid=\"msg_settings_button\"]");

    public MsgChatsListToolbarElement() {
        super(chatsListToolbar);
    }

    public MsgMainElement openMsgMain() {
        elementFromRoot(msgMainBtn).click();
        return new MsgMainElement();
    }

}
