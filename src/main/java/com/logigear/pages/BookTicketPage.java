package com.logigear.pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.model.BookTicket;
import com.logigear.pages.base.BasePage;

public class BookTicketPage extends BasePage {

    // Element
    private final Label selectBookDate = new Label("//select[@name='Date']");
    private final Label selectDepartFrom = new Label("//select[@name='DepartStation']");
    private final Label selectArriveTo = new Label("//select[@name='ArriveStation']");
    private final Label selectSeatType = new Label("//select[@name='SeatType']");
    private final Label selectTicketAmount = new Label("//select[@name='TicketAmount']");
    private final Label optionIndex = new Label("//select[@name='TicketAmount']/option[@value='%s']");
    private final Button bookTicketBtn = new Button("//input[@value='Book ticket']");

    // Function
    private void selectSeatAmount(int index) {
        optionIndex.setDynamicValue(index);
        selectTicketAmount.scrollToView();
        selectTicketAmount.click();
        optionIndex.waitForElementClickable();
        optionIndex.click();
    }

    private void selectBookDate(String bookDate) {
        selectBookDate.scrollToView();
        selectBookDate.click();
        selectOptionTextView(bookDate);
    }

    private void selectDepartFrom(String departFrom) {
        selectDepartFrom.scrollToView();
        selectDepartFrom.click();
        selectOptionTextView(departFrom);
    }

    private void selectArriveTo(String arriveTo) {
        selectArriveTo.scrollToView();
        selectArriveTo.click();
        selectOptionTextView(arriveTo);
    }

    private void selectSeatType(String seatType) {
        selectSeatType.scrollToView();
        selectSeatType.click();
        selectOptionTextView(seatType);
    }

    private void clickBookTicket() {
        bookTicketBtn.click();
    }

    public void bookTicket(BookTicket bookTicket) {
        selectBookDate(bookTicket.getDepartDate());
        selectDepartFrom(bookTicket.getDepartFrom());
        selectArriveTo(bookTicket.getArriveAt());
        selectSeatType(bookTicket.getSeatType());
        selectSeatAmount(bookTicket.getTicketAmount());
        clickBookTicket();
    }
}
