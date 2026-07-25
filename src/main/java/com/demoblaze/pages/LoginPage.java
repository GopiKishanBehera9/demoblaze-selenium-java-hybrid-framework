package com.demoblaze.pages;

import org.openqa.selenium.By;

import com.demoblaze.base.BasePage;

/**
 * Page Object for Login functionality.
 *
 * @author Gopi Kishan Behera
 */
public class LoginPage extends BasePage {

    // ==========================
    // Locators
    // ==========================

    private final By usernameTextBox = By.id("loginusername");

    private final By passwordTextBox = By.id("loginpassword");

    private final By loginButton = By.xpath("//button[text()='Log in']");

    private final By closeButton = By.xpath("//div[@id='logInModal']//button[text()='Close']");

    private final By loginModal = By.id("logInModal");

    private final By welcomeUser = By.id("nameofuser");

    // ==========================
    // Actions
    // ==========================

    public boolean isLoginModalDisplayed() {
        return actions.isDisplayed(loginModal);
    }

    public void enterUsername(String username) {
        actions.type(usernameTextBox, username);
    }

    public void enterPassword(String password) {
        actions.type(passwordTextBox, password);
    }

    public void clickLoginButton() {
        actions.click(loginButton);
    }

    public void clickCloseButton() {
        actions.click(closeButton);
    }

    /**
     * Performs complete login.
     */
    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLoginButton();

    }

    /**
     * Verify successful login.
     */
    public boolean isUserLoggedIn() {

        return actions.isDisplayed(welcomeUser);

    }

}