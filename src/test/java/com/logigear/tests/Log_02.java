package com.logigear.tests;

import com.logigear.common.TestBase;
import com.logigear.data.Constants;
import com.logigear.data.enums.HomePageNavigate;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import com.logigear.pages.RegisterPage;
import com.logigear.utils.Assertion;
import org.testng.annotations.Test;

public class Log_02 extends TestBase {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(description = "Verify that clicking on the hyperlink text \"registration page\" will redirect to the Register page")
    public void Log_02_VerifyThatClickingOnTheHyperlinkTextRegistrationPageWillRedirectToTheRegisterPage() {
        homePage.navigateToPage(HomePageNavigate.LOGIN);

        loginPage.gotoRegisterPage();

        Assertion.assertTrue(registerPage.checkPageTitle(Constants.REGISTER_PAGE_TITLE), "The register page is displayed.");
    }
}
