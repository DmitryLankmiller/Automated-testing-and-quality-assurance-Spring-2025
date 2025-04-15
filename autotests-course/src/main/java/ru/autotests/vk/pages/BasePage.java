package ru.autotests.vk.pages;

public abstract class BasePage {
    public static final String BASE_URL = "https://ok.ru";

    abstract void checkPage();

    public BasePage() {
        checkPage();
    }
}
