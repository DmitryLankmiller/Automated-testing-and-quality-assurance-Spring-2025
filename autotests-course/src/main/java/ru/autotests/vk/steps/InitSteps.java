package ru.autotests.vk.steps;

import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.autotests.vk.pages.BasePage;

public class InitSteps {

    public static void initWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public static void initSelenide() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--accept-lang=ru-RU");
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = BasePage.BASE_URL;
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }

    public void setUpTest() {
        Selenide.open("/");
    }

    public void tearDownTest() {
        Selenide.closeWebDriver();
    }

    public void restartBrowser() {
        Selenide.closeWebDriver();
        Selenide.open("/");
    }
}
