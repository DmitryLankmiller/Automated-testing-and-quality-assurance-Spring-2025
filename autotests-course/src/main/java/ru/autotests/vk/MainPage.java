package ru.autotests.vk;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class MainPage extends BasePage {
    private static final SelenideElement feed = $(By.id("hook_Block_MainFeedsContent"));
    private static final SelenideElement profileBtn = $(By.xpath(".//*[@data-l=\"t,userPage\"]"));
    private static final SelenideElement profileDropdownMenu = $(
            By.xpath(".//button[@aria-controls=\"user-dropdown-menu\"]"));
    private static final SelenideElement logoutBtn = $(By.xpath(".//*[@data-l=\"t,logout\"]"));

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
    }

    public void clickLogoutBtn() {
        logoutBtn.click();
    }

    public LoginPage logout() {
        expandDropdownMenu();
        clickLogoutBtn();
        return new LoginPage();
    }

}
