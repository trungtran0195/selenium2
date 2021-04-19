package com.logigear.data.enums;

public enum HomePageNavigate {
    HOME("Home"),
    FAQ("FAQ"),
    CONTACT("Contact"),
    TIME_TABLE("Timetable"),
    TICKET_PRICE("Ticket price"),
    BOOK_TICKET("Book ticket"),
    REGISTER("Register"),
    LOGIN("Login");

    private final String value;

    public String getValue() {
        return value;
    }

    HomePageNavigate(String value) {
        this.value = value;
    }

    public static HomePageNavigate[] getHeaders() {
        return values();
    }
}