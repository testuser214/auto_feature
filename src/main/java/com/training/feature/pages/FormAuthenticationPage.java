package com.training.feature.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class FormAuthenticationPage {

    private static final By USERNAME = byId("username");
    private static final By PASSWORD = byId("password");
    private static final By RESULT_MESSAGE = byId("flash");
    private static final By LOGIN_BUTTON = byXpath("//i[contains(text(),'Login')]");

    @Step("Click on Login button")
    public FormAuthenticationPage clickOnLoginButton(){
        
        $(LOGIN_BUTTON).click();
        return this;
    }

    public boolean isResultMessageShown(){
        return $(RESULT_MESSAGE).isDisplayed();
    }

    public String getTextFromResultMessage(){
        return $(RESULT_MESSAGE).getText();
    }

    @Step("Set username")
    public FormAuthenticationPage setUsername(String username){
        $(USERNAME).val(username);
        return this;
    }

    @Step("Set password")
    public FormAuthenticationPage setPassword (String password) {
        $(PASSWORD).val(password);
        return this;
    }
}

