package com.logigear.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String BROWSER_SETTING_FILE = "src/test/resources/browsers.setting.properties";

    // Formatter
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("M/dd/uuuu");

    // Timeout variables
    public static final int PRECONDITION_INTERVAL = 5;
    public static final int LONG_TIME = 60;
    public static final int SHORT_TIME = 30;
    public static final int VERY_SHORT_TIME = 1;
    public static final int SLEEP_TIME = 3;
    public static final int DEFAULT_TIME = 5;
    public static final int LOADING_TIME = 10;
    public static final int WAIT_FOR_DISPLAY_TIME = 3;

    // Data
    public static final String INVALID_EMAIL = "duyduy@gmail.com";
    public static final String VALID_EMAIL = "trantrung0195@gmail.com";
    public static final String PASSWORD = "1234abcd";
    public static final String ID = "1234abcd";
    public static final String BOOK_DATE = LocalDate.now().plusDays(2).format(DATE_TIME_FORMATTER);
    public static final List<String> DEPART_LIST =
            Arrays.asList("Sài Gòn", "Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi");
    public static final List<String> ARRIVE_LIST =
            Arrays.asList("Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi");
    public static final List<String> SEAT_TYPE =
            Arrays.asList("Hard seat", "Soft seat", "Soft seat with air conditioner", "Hard bed", "Soft bed", "Soft bed with air conditioner");
    public static final int SEAT_NUMBER = 1;


    // Message
    public static final String INVALID_EMAIL_ERROR = "This email address is already in use.";

    // Page title
    public static final String REGISTER_PAGE_TITLE = "Create account";
    public static final String LOGIN_PAGE_TITLE = "Login page";
}
