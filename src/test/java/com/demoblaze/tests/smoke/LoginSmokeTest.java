package com.demoblaze.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoblaze.base.BaseTest;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;

/**
 * Smoke Test for Login Popup.
 *
 * @author Gopi Kishan Behera
 */
public class LoginSmokeTest extends BaseTest {

    @Test(description = "Verify Login popup is displayed")
    public void verifyLoginPopupIsDisplayed() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginModalDisplayed(),
                "Login popup is not displayed.");

    }

}