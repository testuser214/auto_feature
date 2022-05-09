package com.training.feature.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class AddingRemovingElementsPage {

    private static final By ADD_ELEMENT_BUTTON = byXpath("//button[@onclick='addElement()']");
    private final By ADDED_ELEMENTS = byCssSelector(".added-manually");


    @Step("Add Elements")
    public void addElements(int numberOfElements){
        for(int i = numberOfElements; i > 0; i--) {
            $(ADD_ELEMENT_BUTTON).click();
        }
    }

    @Step("Delete Elements")
    public void deleteElements(){
        for(SelenideElement element: $$(ADDED_ELEMENTS)){
            element.click();
        }
    }

    @Step("Count Elements")
    public int countNumberOfAddedElements(){
        return $$(ADDED_ELEMENTS).size();
    }
}


