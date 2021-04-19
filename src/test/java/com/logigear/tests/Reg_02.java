package com.logigear.tests;

import com.logigear.common.TestBase;
import com.logigear.data.Constants;
import com.logigear.data.enums.HomePageNavigate;
import com.logigear.pages.HomePage;
import com.logigear.pages.RegisterPage;
import com.logigear.utils.Assertion;
import org.testng.annotations.Test;

public class Reg_02 extends TestBase {

    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(description = "Verify that user cannot create new account using Email that has been registered")
    public void Reg_02_VerifyThatUserCannotCreateNewAccountUsingEmailThatHasBeenRegistered() {
        homePage.navigateToPage(HomePageNavigate.REGISTER);

        registerPage.registerNewAccount(Constants.INVALID_EMAIL, Constants.PASSWORD, Constants.ID);

        Assertion.assertTrue(registerPage.checkRegisterErrorMessage(Constants.INVALID_EMAIL_ERROR), "The register page is displayed.");
    }
}
