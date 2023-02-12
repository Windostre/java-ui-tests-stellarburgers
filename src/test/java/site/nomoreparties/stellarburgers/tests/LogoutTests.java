package site.nomoreparties.stellarburgers.tests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import site.nomoreparties.stellarburgers.helpers.BrowserRules;
import site.nomoreparties.stellarburgers.helpers.Utils;
import site.nomoreparties.stellarburgers.model.UserData;
import site.nomoreparties.stellarburgers.pom_pages.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LogoutTests {
    @Rule
    public BrowserRules browserRules = new BrowserRules(BrowserRules.CHROME);
    private Utils utils = new Utils();
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ProfilePage profilePage;
    private UserData loginData;

    @Before
    public void localSetUp() {
        mainPage = new MainPage(browserRules.getDriver());
        loginPage = new LoginPage(browserRules.getDriver());
        registerPage = new RegisterPage(browserRules.getDriver());
        profilePage = new ProfilePage(browserRules.getDriver());
        loginData = utils.defaultLoginData();
    }

    @Test
    public void logoutViaProfileSuccess() throws InterruptedException {
        mainPage.open();
        mainPage.clickUserProfile();
        loginPage.logIn(loginData);
        mainPage.clickUserProfile();

        assertTrue(profilePage.isCurrentPositionProfilePage());

        profilePage.logout();

        assertThat(loginPage.getAccessToken(), is(nullValue()));
        assertTrue(loginPage.isCurrentPositionLoginPage());

    }



}
