package com.training.feature.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.training.feature.helpers.WaitHelper.waitForElementVisible;

public class BasicAuthPage {

    public static final By SUCCESS_MESSAGE = byXpath("//p[contains(text(), 'Congratulations')]");

    @Step("Wait for Congratulations Message")
    public void waitForCongratulationsMessage(){
        waitForElementVisible(SUCCESS_MESSAGE);
    }
}