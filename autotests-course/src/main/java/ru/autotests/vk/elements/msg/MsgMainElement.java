package ru.autotests.vk.elements.msg;

import static com.codeborne.selenide.Condition.text;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import ru.autotests.vk.elements.ElementWithRoot;

public class MsgMainElement extends ElementWithRoot {
    private static final By chatMain = By.xpath(".//*[@data-tsid=\"chat_main\"]");
    private static final By contacts = By.xpath(".//*[@data-l=\"t,contact\"]");

    public MsgMainElement() {
        super(chatMain);
    }

    private SelenideElement contactByUserName(String userName) {
        return elementsFromRoot(contacts).findBy(text(userName));
    }

    public MsgChatElement openChatByUserName(String userName) {
        contactByUserName(userName).click();
        return new MsgChatElement();
    }

}
