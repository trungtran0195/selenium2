package com.logigear.pages;

import com.logigear.control.common.imp.Label;
import com.logigear.model.BookTicket;
import com.logigear.pages.base.BasePage;

public class TicketBookedSuccessPage extends BasePage {

    // Element
    private final Label departInfo = new Label("//tr[@class='OddRow']/td[1]");
    private final Label arriveInfo = new Label("//tr[@class='OddRow']/td[2]");
    private final Label seatTypeInfo = new Label("//tr[@class='OddRow']/td[3]");
    private final Label departDateInfo = new Label("//tr[@class='OddRow']/td[4]");
    private final Label bookDateInfo = new Label("//tr[@class='OddRow']/td[5]");
    private final Label expiredDateInfo = new Label("//tr[@class='OddRow']/td[6]");
    private final Label amountInfo = new Label("//tr[@class='OddRow']/td[7]");
    private final Label totalPriceInfo = new Label("//tr[@class='OddRow']/td[8]");

    // Function
    public boolean checkIdCorrect(String id) {
        Label idView = new Label("//strong[.='%s']");
        idView.setDynamicValue(id);
        return idView.isDisplayed();
    }

    public boolean checkTicketInfoCorrect(BookTicket bookTicket) {
        departDateInfo.scrollToView();
        boolean result = departInfo.getText().equals(bookTicket.getDepartFrom());
        result = result && arriveInfo.getText().equals(bookTicket.getArriveAt());
        result = result && seatTypeInfo.getText().equals(bookTicket.getSeatType());
        result = result && departDateInfo.getText().equals(bookTicket.getDepartDate());
        return result;
    }
}
