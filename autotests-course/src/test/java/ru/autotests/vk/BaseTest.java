package ru.autotests.vk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import ru.autotests.vk.steps.InitSteps;

public class BaseTest {
    private final InitSteps initSteps = new InitSteps();

    @BeforeAll
    public static void initSelenide() {
        InitSteps.initWebDriver();
        InitSteps.initSelenide();
    }

    @BeforeEach
    public void setUp() {
        initSteps.setUpTest();
    }

    @AfterEach
    public void tearDown() {
        initSteps.tearDownTest();
    }
}
