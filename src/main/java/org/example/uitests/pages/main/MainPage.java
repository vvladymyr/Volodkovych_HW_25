package org.example.uitests.pages.main;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "#menu_button_container > div > div:nth-child(3) > div > button")
    private WebElement menuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;
    @FindBy(id = "shopping_cart_container")
    private WebElement cartBadgeButton;

    public MainPage () {
        super();
    }
    public void logout() {
        menuButton.click();
        logoutButton.click();
    }
    public void allItems() {
        menuButton.click();
        allItemsButton.click();
    }
    public void cartBadge() {
        cartBadgeButton.click();
    }
    }