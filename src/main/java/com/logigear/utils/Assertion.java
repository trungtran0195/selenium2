package com.logigear.utils;

import com.logigear.report.Reporter;

public class Assertion {

    public static void assertTrue(boolean condition, String message) {
        message = "VP. " + message;
        if (condition) {
            Reporter.logPass(message);
        } else {
            Reporter.logFail(message);
            throw new AssertionError();
        }
    }

    public static void assertTrue(boolean condition, String message, String codeInfo) {
        if (condition) {
            Reporter.logPass(message);
            Reporter.logCode(codeInfo);
        } else {
            Reporter.logFail(message);
            Reporter.logCode(codeInfo);
            throw new AssertionError();
        }
    }

    public static void assertFalse(boolean condition, String message) {
        message = "VP. " + message;
        if (!condition) {
            Reporter.logPass(message);
        } else {
            Reporter.logFail(message);
            throw new AssertionError();
        }
    }

}
