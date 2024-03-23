package com.longph31848.assignment.util;

import java.util.Calendar;

public class DateNow {
    private static Calendar calendar;

    public static Long getTimeNow() {
        calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    public static void main(String[] args) {
        System.out.println("Timenow: " + getTimeNow());
    }
}
