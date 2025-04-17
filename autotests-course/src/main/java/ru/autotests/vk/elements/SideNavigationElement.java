package ru.autotests.vk.elements;

import org.openqa.selenium.By;

public class SideNavigationElement extends ElementWithRoot {
    private static final By sideNavigation = By.id("hook_Block_SideNavigation");
    private static final By profileBtn = By.xpath(".//*[@data-l=\"t,userPage\"]");

    public SideNavigationElement() {
        super(sideNavigation);
    }

    public String getUserName() {
        return elementFromRoot(profileBtn).getText();
    }

}