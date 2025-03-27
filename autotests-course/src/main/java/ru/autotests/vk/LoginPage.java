package ru.autotests.vk;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final SelenideElement loginInput = $(By.id("field_email"));
    private static final SelenideElement passwordInput = $(By.id("field_password"));
    private static final SelenideElement loginBtn = $(By.xpath(".//input[@data-l=\"t,sign_in\"]"));

    @Override
    void checkPage() {
        loginInput.shouldBe(enabled);
        passwordInput.shouldBe(enabled);
    }

    public MainPage loginByEmail(String email, String password) {
        loginInput.setValue(email);
        passwordInput.setValue(password);
        loginBtn.click();
        return new MainPage();
    }

    public void writeLogin(String login) {
        loginInput.setValue(login);
    }

    public void writePassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

}
