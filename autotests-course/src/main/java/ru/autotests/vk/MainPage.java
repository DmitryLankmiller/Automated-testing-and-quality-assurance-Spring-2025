package ru.autotests.vk;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class MainPage extends BasePage {
    private static final SelenideElement feed = $(By.id("hook_Block_MainFeedsContent"));
    private static final SelenideElement profileBtn = $(By.xpath("data-l=\"t,userPage\""));

    @Override
    void checkPage() {
        feed.shouldBe(visible);
        profileBtn.shouldBe(visible);
    }

    public String getUserName() {
        return profileBtn.getText();
    }

}
