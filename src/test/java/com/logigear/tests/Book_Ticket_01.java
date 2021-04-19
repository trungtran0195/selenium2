package com.logigear.tests;

import com.logigear.common.TestBase;
import com.logigear.data.Constants;
import com.logigear.data.enums.HomePageNavigate;
import com.logigear.model.BookTicket;
import com.logigear.pages.BookTicketPage;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import com.logigear.pages.TicketBookedSuccessPage;
import com.logigear.utils.Assertion;
import org.testng.annotations.Test;

public class Book_Ticket_01 extends TestBase {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final TicketBookedSuccessPage ticketBookedSuccessPage = new TicketBookedSuccessPage();
    private final BookTicket bookTicket = new BookTicket();

    @Test(description = "Verify that the \"Ticket booked successfully!\" page displays correct information")
    public void Book_Ticket_01_VerifyThatTheTicketBookedSuccessfullyPageDisplaysCorrectInformation() {

        homePage.navigateToPage(HomePageNavigate.LOGIN);

        loginPage.login(Constants.VALID_EMAIL, Constants.PASSWORD);

        homePage.navigateToPage(HomePageNavigate.BOOK_TICKET);

        bookTicketPage.bookTicket(bookTicket);

        Assertion.assertTrue(ticketBookedSuccessPage.checkIdCorrect(Constants.ID), "The login page is displayed.");

        Assertion.assertTrue(ticketBookedSuccessPage.checkTicketInfoCorrect(bookTicket), "The login page is displayed.");
    }
}
