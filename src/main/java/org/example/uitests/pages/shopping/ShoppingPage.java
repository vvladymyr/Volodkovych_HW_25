package org.example.uitests.pages.shopping;

import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingPage extends BasePage {


    @FindBy(css = "#inventory_container > div > div:nth-child(1) > div.pricebar > button")
    private WebElement addButton;
    @FindBy(css = "#inventory_container > div > div:nth-child(2) > div.pricebar > button")
    private WebElement addButtonTwo;
    @FindBy(css = "#inventory_container > div > div:nth-child(1) > div.pricebar > button")
    private WebElement removeButtont;

    public ShoppingPage() {
        super();
    }

    public void addProductToCart() {
        addButton.click();
    }
    public void addProductToCartTwo() {
        addButtonTwo.click();
    }
    public void removeProductFromCart() {

        removeButtont.click();
    }

}