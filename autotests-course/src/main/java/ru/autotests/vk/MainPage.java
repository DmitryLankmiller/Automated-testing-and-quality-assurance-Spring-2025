package ru.autotests.vk;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final By feed = By.id("hook_Block_MainFeedsContent");
    private static final By profileBtn = By.xpath(".//*[@data-l=\"t,userPage\"]");
    private static final By profileDropdownMenu = By.xpath(".//button[@aria-controls=\"user-dropdown-menu\"]");
    private static final By logoutBtn = By.xpath(".//*[@data-l=\"t,logout\"]");
    private static final By confirmLogoutMenu = By.xpath(".//*[@id=\"hook_Form_PopLayerLogoffUserModalForm\"]");
    private static final By confirmLogoutBtn = By.xpath(".//*[@name=\"logoff.confirm_not_decorate\"]");
    private static final By messagesBtn = By.xpath(".//*[@id=\"msg_toolbar_button\"]");

    @Override
    void checkPage() {
        $(feed).shouldBe(visible);
        $(profileBtn).shouldBe(visible);
    }

    public String getUserName() {
        return $(profileBtn).getText();
    }

    public MainPage expandProfileDropdownMenu() {
        $(profileDropdownMenu).click();
        return this;
    }

    public MainPage clickLogoutBtn() {
        $(logoutBtn).click();
        return this;
    }

    public MainPage confirmLogoutMenuShouldBeVisible() {
        $(confirmLogoutMenu).shouldBe(visible);
        return this;
    }

    public LoginPage confirmLogout() {
        $(confirmLogoutBtn).click();
        return new LoginPage();
    }

    public MsgPage clickMessageBtn() {
        $(messagesBtn).click();
        return new MsgPage();
    }

}
