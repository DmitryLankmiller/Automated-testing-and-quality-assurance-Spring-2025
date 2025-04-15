package ru.autotests.vk.elements;

import org.openqa.selenium.By;

import ru.autotests.vk.pages.LoginPage;

public class LogoutWidgetElement extends ElementWithRoot {
    private static final By logoutWidget = By
            .xpath(".//*[@id=\"hook_Modal_popLayerModal\"]//*[@class=\"modal-new_hld\"]");
    private static final By confirmLogoutBtn = By.xpath(".//*[@name=\"logoff.confirm_not_decorate\"]");

    public LogoutWidgetElement() {
        super(logoutWidget);
    }

    public LoginPage confirmLogout() {
        element(confirmLogoutBtn).click();
        return new LoginPage();
    }

}
