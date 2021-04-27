package com.logigear.pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.Label;
import com.logigear.data.Constants;
import com.logigear.model.BookTicket;
import com.logigear.pages.base.BasePage;

public class BookTicketPage extends BasePage {

    // Element
    private final ComboBox selectBookDate = new ComboBox("//select[@name='Date']");
    private final ComboBox selectDepartFrom = new ComboBox("//select[@name='DepartStation']");
    private final ComboBox selectArriveTo = new ComboBox("//span[@id='ArriveStation']/select");
    private final ComboBox selectSeatType = new ComboBox("//select[@name='SeatType']");
    private final ComboBox selectTicketAmount = new ComboBox("//select[@name='TicketAmount']");
    private final Button bookTicketBtn = new Button("//input[@value='Book ticket']");

    // Function
    private void selectSeatAmount(int index) {
        selectTicketAmount.select(index);
    }

    private void selectBookDate(String bookDate) {
        selectBookDate.scrollToView();
        selectBookDate.select(bookDate);
    }

    private void selectDepartFrom(String departFrom) {
        selectDepartFrom.scrollToView();
        selectDepartFrom.select(departFrom);
    }

    private void selectArriveTo(String arriveTo) {
        selectArriveTo.scrollToView();
        selectArriveTo.select(arriveTo);
    }

    private void selectSeatType(String seatType) {
        selectSeatType.scrollToView();
        selectSeatType.select(seatType);
    }

    private void clickBookTicket() {
        bookTicketBtn.click();
    }

    public void bookTicket(BookTicket bookTicket) {
        selectBookDate(bookTicket.getDepartDate());
        selectDepartFrom(bookTicket.getDepartFrom());
        selectSeatType(bookTicket.getSeatType());
        selectArriveTo(bookTicket.getArriveAt());
        selectSeatAmount(bookTicket.getTicketAmount());
        clickBookTicket();
    }
}
