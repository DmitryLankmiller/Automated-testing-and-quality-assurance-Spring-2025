package ru.autotests.vk.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final By loginInput = By.id("field_email");
    private static final By passwordInput = By.id("field_password");
    private static final By loginBtn = By.xpath(".//input[@data-l=\"t,sign_in\"]");
    private static final By loginFailedMessage = By.xpath(".//*[contains(@class,\"login_error\")]");

    @Override
    void checkPage() {
        $(loginInput).shouldBe(clickable);
        $(passwordInput).shouldBe(clickable);
    }

    public MainPage loginByEmail(String email, String password) {
        $(loginInput).setValue(email);
        $(passwordInput).setValue(password);
        $(loginBtn).click();
        return new MainPage();
    }

    public LoginPage loginInputShouldBeEnabled() {
        $(loginInput).shouldBe(clickable);
        return this;
    }

    public LoginPage writeLogin(String login) {
        $(loginInput).setValue(login);
        return this;
    }

    public LoginPage passwordInputShouldBeEnabled() {
        $(passwordInput).shouldBe(clickable);
        return this;
    }

    public LoginPage writePassword(String password) {
        $(passwordInput).setValue(password);
        return this;
    }

    public void clickLoginBtn() {
        $(loginBtn).click();
    }

    public LoginPage loginFailedMessageShouldBeVisible() {
        $(loginFailedMessage).shouldBe(visible);
        return this;
    }

    public String getLoginFailedMessageText() {
        return $(loginFailedMessage).innerText();
    }

}
