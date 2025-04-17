package ru.autotests.vk.elements;

import org.openqa.selenium.By;

public class ProfileDropDownMenuElement extends ElementWithRoot {
    private static final By userDropDownMenu = By.id("user-dropdown-menu");
    private static final By logoutBtn = By.xpath(".//*[@data-l=\"t,logout\"]");

    public ProfileDropDownMenuElement() {
        super(userDropDownMenu);
    }

    public LogoutWidgetElement clickLogoutBtn() {
        elementFromRoot(logoutBtn).click();
        return new LogoutWidgetElement();
    }

}
