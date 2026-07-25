package com.demoblaze.pages;

import org.openqa.selenium.By;

import com.demoblaze.base.BasePage;

/**
 * HomePage
 *
 * Page Object for Demoblaze Home Page.
 *
 * @author Gopi Kishan Behera
 */
public class HomePage extends BasePage {

    // ==========================
    // Locators
    // ==========================

    private final By homeMenu = By.linkText("Home");

    private final By contactMenu = By.id("contact2");

    private final By aboutUsMenu = By.id("videolink");

    private final By cartMenu = By.id("cartur");

    private final By loginMenu = By.id("login2");

    private final By signUpMenu = By.id("signin2");

    private final By logoutMenu = By.id("logout2");

    private final By welcomeUser = By.id("nameofuser");

    // ==========================
    // Actions
    // ==========================

    public void clickHome() {
        actions.click(homeMenu);
    }

    public void clickContact() {
        actions.click(contactMenu);
    }

    public void clickAboutUs() {
        actions.click(aboutUsMenu);
    }

    public void clickCart() {
        actions.click(cartMenu);
    }

    public void clickLogin() {
        actions.click(loginMenu);
    }

    public void clickSignUp() {
        actions.click(signUpMenu);
    }

    public void clickLogout() {
        actions.click(logoutMenu);
    }

    public boolean isLogoutDisplayed() {
        return actions.isDisplayed(logoutMenu);
    }

    public boolean isUserLoggedIn() {
        return actions.isDisplayed(welcomeUser);
    }

    public String getLoggedInUsername() {
        return actions.getText(welcomeUser);
    }

}