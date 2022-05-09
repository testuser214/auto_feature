package com.training.feature.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WaitHelper {

    private static final int MAX_TIMEOUT = 30;
    private static final int TIME_OUT = 20;
    private static final int WAIT_ASSURED = 15;


    public static boolean waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(MAX_TIMEOUT));
        Selenide.sleep(WAIT_ASSURED);
        try {
            wait.until(visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException | ElementShould e) {
            return false;
        }
    }

    //waiting element using selenide
    public static void waitForElementVisible(By locator) {
        $(locator).should(Condition.visible, Duration.ofSeconds(TIME_OUT));
    }

}
