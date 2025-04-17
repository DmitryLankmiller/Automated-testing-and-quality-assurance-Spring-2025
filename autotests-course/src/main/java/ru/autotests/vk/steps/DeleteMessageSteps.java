package ru.autotests.vk.steps;

import ru.autotests.vk.elements.msg.MsgChatElement;

public class DeleteMessageSteps {
    public void deleteLastMessageInChat(MsgChatElement chat) {
        var confirmDelete = chat.lastMessageShouldBeVisible()
                .hoverLastMessage()
                .clickMessageMoreActionsBtn()
                .clickDeleteMessageBtn();
        confirmDelete.clickConfirmDeleteBtn();
    }
}
