package ru.autotests.vk;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import org.openqa.selenium.By;

import com.codeborne.selenide.ClickOptions;
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

    public void expandDropdownMenu() {
        profileDropdownMenu.click();
        logoutBtn.shouldBe(enabled);
    }

    public void clickLogoutBtn() {
        logoutBtn.click();
        confirmLogoutMenu.shouldBe(visible);
        confirmLogoutBtn.shouldBe(enabled);
    }

    public void confirmLogout() {
        ClickOptions options = ClickOptions
                .withOffset(
                        confirmLogoutBtn.getRect().width / 2,
                        confirmLogoutBtn.getRect().height / 2);
        confirmLogoutBtn.click(options);
    }

    public LoginPage logout() {
        expandDropdownMenu();
        clickLogoutBtn();
        confirmLogout();
        return new LoginPage();
    }

    public MsgPage clickMessageBtn() {
        messagesBtn.click();
        return new MsgPage();
    }

}
