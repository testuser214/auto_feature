package com.training.feature.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DropdownPage {

    private static final By SELECT_OPTION = byXpath("//select[@id]");
    private static By OPTION_LOCATOR ;


    public boolean isOptionByValueSelected(String value){
       boolean result = $(By.xpath(String.format("//option[@value='%s']", value))).isSelected();
       return result;
    }
    public boolean isOptionByIndexSelected(int i){
        boolean result = Selenide.$(By.xpath(String.format("//option[contains(text(),'Option')]["+i+"]"))).isSelected();
        return result;
    }

    @Step("Select Option By Value")
    public static void selectOption(String optionValue){
        $(SELECT_OPTION).selectOptionByValue(optionValue);
    }

    @Step("Select Option By Index")
    public void selectOptionByIndex(int optionNumber){
        $(SELECT_OPTION).selectOption(optionNumber);
    }

}
