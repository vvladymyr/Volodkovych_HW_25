package org.example.uitests;

import org.example.uitests.pages.cart.CartPage;
import org.example.uitests.pages.login.LoginPage;
import org.example.uitests.pages.main.MainPage;
import org.example.uitests.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class ProductsTests extends BaseTestClass {
    @Test
    public void loginNotCredentialsTest() {
        goToUrl();

        LoginPage loginPage = new LoginPage().loginNotCredentials();
        String errorText = loginPage.getErrorText();
        Assert.assertEquals(errorText, "Epic sadface: Username is required");
    }

    @Test
    public void loginTest() {
        goToUrl();

        LoginPage loginPage = new LoginPage().login(getUserName(), getUserPass());
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Redirected to page after logout");
    }

    @Test
    public void shoppingCartTest() {
        goToUrl();

        LoginPage loginPage = new LoginPage().login(getUserName(), getUserPass());
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.addProductToCart();
        MainPage mainPage = new MainPage();
        mainPage.cartBadge();
        CartPage cartPage = new CartPage();

        Assert.assertEquals(CartPage.getProductCount(), 1, "Product count should be 1");

        mainPage.allItems();

        shoppingPage.addProductToCartTwo();
        mainPage.cartBadge();
        Assert.assertEquals(CartPage.getProductCount(), 2, "Product count should be 2");
        mainPage.allItems();

        shoppingPage.removeProductFromCart();
        mainPage.cartBadge();
        Assert.assertEquals(CartPage.getProductCount(), 1, "Product count should be 1");

        mainPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"), "Redirected to login page after logout");
    }
}
