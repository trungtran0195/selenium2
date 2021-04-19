package com.logigear.tests;

import com.logigear.common.TestBase;
import com.logigear.data.Constants;
import com.logigear.data.enums.HomePageNavigate;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import com.logigear.utils.Assertion;
import org.testng.annotations.Test;

public class Log_01 extends TestBase {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test(description = "Verify that user can open the Login page")
    public void Log_01_VerifyThatUserCanOpenTheLoginPage() {
        homePage.navigateToPage(HomePageNavigate.LOGIN);

        Assertion.assertTrue(loginPage.checkPageTitle(Constants.LOGIN_PAGE_TITLE), "The login page is displayed.");
    }
}
