package ru.autotests.vk.elements;

import org.openqa.selenium.By;

import ru.autotests.vk.pages.MsgPage;

public class ToolbarElement extends ElementWithRoot {
    private static final By topPanel = By.id("topPanel");
    private static final By profileDropdownMenuBtn = By.xpath(".//button[@aria-controls=\"user-dropdown-menu\"]");
    private static final By messagesBtn = By.xpath(".//*[@id=\"msg_toolbar_button\"]");

    public ToolbarElement() {
        super(topPanel);
    }

    public ProfileDropDownMenuElement expandProfileDropdownMenu() {
        element(profileDropdownMenuBtn).click();
        return new ProfileDropDownMenuElement();
    }

    public MsgPage clickMessageBtn() {
        element(messagesBtn).click();
        return new MsgPage();
    }

}
