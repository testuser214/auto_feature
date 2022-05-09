package com.training.feature.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class DownloadPage {

    private static final By SOME_TXT_FILE = byAttribute("href", "download/test.txt");
    private static final By SAMPLE_PDF_FILE = byAttribute("href", "download/sample.pdf");


    public File downloadSamplePDF() throws FileNotFoundException {
        File pdfFile = $(SAMPLE_PDF_FILE).download(500);
       return pdfFile;
    }

    @Step("Download txt File")
    public File downloadDummyTxt() throws FileNotFoundException {
       File txtFile = $(SOME_TXT_FILE).download(500);
       return txtFile;
    }

}