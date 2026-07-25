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

}