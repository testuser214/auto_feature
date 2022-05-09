package com.training.feature.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;


public class CheckboxesPage {

    private static final String checkboxesUrl = "http://the-internet.herokuapp.com/checkboxes";
    private static final By CHECKBOXES_COLLECTION = byXpath("//input[@type='checkbox']");
    private static final By FIRST_CHECKBOX = byXpath("//input[@type='checkbox'][1]");
    private static final By SECOND_CHECKBOX = byXpath("//input[@type='checkbox'][2]");
    private static final int TIME_OUT = 20;

    @Step("Make Checkboxes selected")
    public void makeAllCheckboxesSelected() {
        for (SelenideElement element : $$(CHECKBOXES_COLLECTION)) {
            if (!element.isSelected()) {
                element.click();
            }
        }
    }

    @Step("Validate Checkboxes State")
    public boolean validateCheckboxesState() {
        boolean checkboxStateIsCorrect = false;
        for (SelenideElement element : $$(CHECKBOXES_COLLECTION)) {
           if (element.isSelected())
            { checkboxStateIsCorrect = true;  }
        }
        return checkboxStateIsCorrect;
    }

}
