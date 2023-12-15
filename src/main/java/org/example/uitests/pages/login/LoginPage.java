package org.example.uitests.pages.login;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "#login_button_container > div > form > h3")
    private WebElement error;

    public LoginPage() {
        super();
    }

    private LoginPage setName(String name) {
        enterFileToWebElement(userName, name);
        return this;
    }

    private LoginPage setPassword(String pass) {
        enterFileToWebElement(password, pass);
        return this;
    }

    private LoginPage enterFileToWebElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        return this;
    }

    private void clickLoginButton() {
        loginButton.click();
    }


    public String getErrorText() {
        return error.getText();
    }


    public LoginPage login(String name, String pass) {
        setName(name)
                .setPassword(pass)
                .clickLoginButton();
        return new LoginPage();
    }
    public LoginPage loginNotCredentials() {
        clickLoginButton();
        return new LoginPage();
}
}