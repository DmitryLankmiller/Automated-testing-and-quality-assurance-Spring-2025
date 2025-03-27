package ru.autotests.vk;

public abstract class BasePage {
    public static final String BASE_URL = "https://ok.ru";

    abstract void checkPage();

    public BasePage() {
        checkPage();
    }
}
