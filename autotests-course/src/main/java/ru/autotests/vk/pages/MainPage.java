package ru.autotests.vk.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import ru.autotests.vk.elements.SideNavigationElement;
import ru.autotests.vk.elements.ToolbarElement;

public class MainPage extends BasePage {
    private static final By feed = By.id("hook_Block_MainFeedsContent");
    private final ToolbarElement toolbar;
    private final SideNavigationElement sideNavigation;

    public MainPage() {
        super();
        toolbar = new ToolbarElement();
        sideNavigation = new SideNavigationElement();
    }

    @Override
    void checkPage() {
        $(feed).shouldBe(visible);
    }

    public SideNavigationElement sideNavigation() {
        return this.sideNavigation;
    }

    public ToolbarElement toolbar() {
        return this.toolbar;
    }
}
