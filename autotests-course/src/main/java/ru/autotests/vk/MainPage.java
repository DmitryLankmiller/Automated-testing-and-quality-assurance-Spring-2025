package ru.autotests.vk;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class MainPage extends BasePage {
    private static final SelenideElement feed = $(By.id("hook_Block_MainFeedsContent"));
    private static final SelenideElement profileBtn = $x((".//*[@data-l=\"t,userPage\"]"));
    private static final SelenideElement profileDropdownMenu = $(
            By.xpath(".//button[@aria-controls=\"user-dropdown-menu\"]"));
    private static final SelenideElement logoutBtn = $x((".//*[@data-l=\"t,logout\"]"));
    private static final SelenideElement confirmLogoutMenu = $(
            By.xpath(".//*[@id=\"hook_Form_PopLayerLogoffUserModalForm\"]"));
    private static final SelenideElement confirmLogoutBtn = $x((".//*[@name=\"logoff.confirm_not_decorate\"]"));
    private static final SelenideElement messagesBtn = $x(".//*[@id=\"msg_toolbar_button\"]");

    @Override
    void checkPage() {
        feed.shouldBe(visible);
        profileBtn.shouldBe(visible);
    }

    public String getUserName() {
        return profileBtn.getText();
    }

    public MainPage expandProfileDropdownMenu() {
        profileDropdownMenu.click();
        return this;
    }

    public MainPage clickLogoutBtn() {
        logoutBtn.click();
        return this;
    }

    public MainPage confirmLogoutMenuShouldBeVisible() {
        confirmLogoutMenu.shouldBe(visible);
        return this;
    }

    public LoginPage confirmLogout() {
        confirmLogoutBtn.click();
        return new LoginPage();
    }

    public MsgPage clickMessageBtn() {
        messagesBtn.click();
        return new MsgPage();
    }

}
