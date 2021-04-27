package com.logigear.model;

import com.logigear.data.Constants;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BookTicket {

    private final String departDate;
    private final String departFrom;
    private final String arriveAt;
    private final String seatType;
    private final int ticketAmount;

    public BookTicket() {
        this.departDate = Constants.BOOK_DATE;
        this.departFrom = Constants.DEPART_LIST.get(new Random().nextInt(Constants.DEPART_LIST.size()));
        List<String> arrivalList = Constants.ARRIVE_LIST.stream().filter(n -> !n.equals(this.departFrom)).collect(Collectors.toList());
        this.arriveAt = arrivalList.get(new Random().nextInt(arrivalList.size()));
        this.seatType = Constants.SEAT_TYPE.get(new Random().nextInt(Constants.SEAT_TYPE.size()));
        this.ticketAmount = Constants.SEAT_NUMBER;
    }

    public String getDepartDate() {
        return departDate;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

}
