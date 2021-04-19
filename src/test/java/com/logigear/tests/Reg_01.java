package com.logigear.tests;

import com.logigear.common.TestBase;
import com.logigear.data.Constants;
import com.logigear.data.enums.HomePageNavigate;
import com.logigear.pages.HomePage;
import com.logigear.pages.RegisterPage;
import com.logigear.utils.Assertion;
import org.testng.annotations.Test;

public class Reg_01 extends TestBase {

    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(description = "Verify that user can open the Register page")
    public void Reg_01_VerifyThatUserCanOpenTheRegisterPage() {
        homePage.navigateToPage(HomePageNavigate.REGISTER);

        Assertion.assertTrue(registerPage.checkPageTitle(Constants.REGISTER_PAGE_TITLE), "The register page is displayed.");
    }
}
