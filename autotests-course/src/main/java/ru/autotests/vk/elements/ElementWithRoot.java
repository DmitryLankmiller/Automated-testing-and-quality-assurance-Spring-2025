package ru.autotests.vk.elements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public abstract class ElementWithRoot extends BaseElement {
    private By root;

    public ElementWithRoot(By root) {
        this.root = root;
        this.checkElement();
    }

    @Override
    public void checkElement() {
        $(root).shouldBe(visible);
    }

    protected SelenideElement elementFromRoot(By locator) {
        return $(root).$(locator);
    }

    protected ElementsCollection elementsFromRoot(By locator) {
        return $(root).$$(locator);
    }
}
