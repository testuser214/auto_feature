package com.training.feature.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class ContextMenuPage {

    private static final By HOT_SPOT = byId("hot-spot");

    @Step("Context Click")
    public void contextClickOnHotSpot(){
        $(HOT_SPOT).contextClick();
    }

    @Step("Validate Alert")
    public String getAlertText(){
       Alert alert = switchTo().alert();
        String alertMessage = alert.getText();
        return alertMessage;
    }

    @Step("Confirm Notification")
    public void confirmNotification(){
        confirm();
    }

}
