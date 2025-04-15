package ru.autotests.vk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.autotests.vk.pages.BasePage;

public class BaseTest {
    @BeforeAll
    public static void initSelenide() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions()
                .addArguments("--accept-lang=ru-RU");
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = BasePage.BASE_URL;
        Configuration.browser = "chrome";
        // Configuration.headless = true;
    }

    @BeforeEach
    public void setUp() {
        Selenide.open("/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }


    public static void restartBrowser() {
        Selenide.closeWebDriver();
        Selenide.open("/");
    }
}
