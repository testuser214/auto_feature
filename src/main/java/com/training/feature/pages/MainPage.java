package com.training.feature.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.training.feature.helpers.WaitHelper.waitForElementVisible;

public class MainPage {
    private static final By TITTLE_TEXT = byClassName("heading");
    private static final By A_B_TESTING_TASK = byXpath("//a[contains(text(), 'A/B Testing')]");
    private static final By ADD_REMOVE_ELEMENTS_TASK = byXpath("//a[@href='href='/add_remove_elements/']");
    private static final String URL = "http://the-internet.herokuapp.com/";
    private static final By BASIC_AUTH_TASK = byAttribute("href", "/basic_auth");
    private static final By CHECKBOXES_TASK = byAttribute("href", "/checkboxes");
    private static final By ADDING_REMOVING_ELEMENTS_TASK = byCssSelector("a[href='/add_remove_elements/']");
    private static final By DROPDOWN_TASK = byAttribute("href", "/dropdown");
    private static final By LOGIN_TASK = byAttribute("href", "/login");
    private static final By DOWNLOAD_TASK = byAttribute("href", "/download");
    private static final By CHALLENGING_DOM_TASK = byAttribute("href", "/challenging_dom");
    private static final By CONTEXT_MENU_TASK = byAttribute("href", "/context_menu");

    @Step("Open Context Menu Task")
    public static void openContextMenuTask(){
        $(CONTEXT_MENU_TASK).click();
    }

    @Step("Open Challenging DOM Task")
    public static void openChallengingDOMTask(){
        $(CHALLENGING_DOM_TASK).click();
    }

    @Step("Open Main Page")
    public static void openMainPage(){
        open(URL);
    }

    @Step("Open Download Task")
    public static void openDownloadTask(){
        $(DOWNLOAD_TASK).click();
    }

    @Step("Open Adding/Removing Elements Task")
    public static void openAddingRemovingElementsTask(){
        $(ADDING_REMOVING_ELEMENTS_TASK).click();
     }

    @Step("Open Dropdown Task")
     public static void openDropdownTask(){
        $(DROPDOWN_TASK).click();

     }

    @Step("Open Login Task")
     public static void openLoginTask(){
        $(LOGIN_TASK).click();
     }

    public static void waitUntilWelcomePageIsShown(){
        waitForElementVisible(TITTLE_TEXT);
    }

    public static void clickBasicAuthTask() {
        $(BASIC_AUTH_TASK).click();

    }
    @Step("Open Checkboxes Task")
    public static void openCheckboxesTask() {
        $(CHECKBOXES_TASK).click();

    }

}




