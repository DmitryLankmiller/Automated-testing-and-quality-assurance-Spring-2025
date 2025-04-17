package ru.autotests.vk.elements.msg;

import org.openqa.selenium.By;

import ru.autotests.vk.elements.ElementWithRoot;

public class MsgConfirmDeleteMessageElement extends ElementWithRoot {
    private static final By msgDialog = By.xpath(".//msg-dialog");
    private static final By confirmDeleteBtn = By.xpath(".//*[@data-tsid=\"confirm-primary\"]");

    public MsgConfirmDeleteMessageElement() {
        super(msgDialog);
    }

    public void clickConfirmDeleteBtn() {
        elementFromRoot(confirmDeleteBtn).click();
    }

}
