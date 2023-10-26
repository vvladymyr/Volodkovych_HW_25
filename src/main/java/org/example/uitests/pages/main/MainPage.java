package org.example.uitests.pages.main;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "#content > div")
    private WebElement FileLinkDisplayed;
    public MainPage() {
            super();
        }

        public boolean isFileLinkDisplayed(String fileName) {
            try {
                return FileLinkDisplayed.isDisplayed();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return false;
            }
        }
    }