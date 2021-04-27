package com.logigear.tests;

import com.logigear.common.TestBase;
import com.logigear.data.Constants;
import com.logigear.data.enums.HomePageNavigate;
import com.logigear.model.BookTicket;
import com.logigear.pages.*;
import com.logigear.report.Reporter;
import com.logigear.utils.Assertion;
import org.testng.annotations.Test;

public class Book_Ticket_01 extends TestBase {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final TicketBookedSuccessPage ticketBookedSuccessPage = new TicketBookedSuccessPage();
    private final BookTicket bookTicket = new BookTicket();

    @Test(description = "Verify that the \"Ticket booked successfully!\" page displays correct information")
    public void Book_Ticket_01_VerifyThatTheTicketBookedSuccessfullyPageDisplaysCorrectInformation() {

        Reporter.log("Create account");
        homePage.navigateToPage(HomePageNavigate.REGISTER);
        registerPage.registerNewAccount(Constants.VALID_EMAIL, Constants.PASSWORD, Constants.ID);

        Reporter.log("Step 1: Go to login page");
        homePage.navigateToPage(HomePageNavigate.LOGIN);

        Reporter.log("Step 2: Sign in to railway");
        loginPage.login(Constants.VALID_EMAIL, Constants.PASSWORD);

        Reporter.log("Step 3: Go to book ticket page");
        homePage.navigateToPage(HomePageNavigate.BOOK_TICKET);

        Reporter.log("Step 4: Book a new ticket");
        bookTicketPage.bookTicket(bookTicket);

        Reporter.log("VP: Check User ID is correct");
        Assertion.assertTrue(ticketBookedSuccessPage.checkIdCorrect(Constants.ID), "Id correct.");

        Reporter.log("VP: Check ticket info is correct");
        Assertion.assertTrue(ticketBookedSuccessPage.checkTicketInfoCorrect(bookTicket), "Ticket info correct.");
    }
}
