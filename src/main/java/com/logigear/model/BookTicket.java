package com.logigear.model;

import com.logigear.data.Constants;

import java.util.Random;

public class BookTicket {

    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private int ticketAmount;

    public BookTicket() {
        this.departDate = Constants.BOOK_DATE;
        this.departFrom = Constants.DEPART_LIST.get(new Random().nextInt(Constants.DEPART_LIST.size()));
        this.arriveAt = Constants.ARRIVE_LIST.get(new Random().nextInt(Constants.ARRIVE_LIST.size()));
        this.seatType = Constants.SEAT_TYPE.get(new Random().nextInt(Constants.SEAT_TYPE.size()));
        this.ticketAmount = Constants.SEAT_NUMBER;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
}
