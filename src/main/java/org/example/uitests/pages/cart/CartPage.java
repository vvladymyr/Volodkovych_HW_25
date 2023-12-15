package org.example.uitests.pages.cart;

import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage() {
        super();
    }
    public static int getProductCount() {
        List<WebElement> productItems = WebDriverHolder.getInstance().getDriver().findElements(By.cssSelector(".cart_item"));

        return productItems.size();
    }
}