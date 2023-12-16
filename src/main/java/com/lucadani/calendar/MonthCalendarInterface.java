package com.lucadani.calendar;

import java.util.List;

public interface MonthCalendarInterface {
    boolean isLeapYear(int year);
    int dayNumber(int day, int month, int year);
    String getMonthName(int monthNumber);
    int numberOfDays(int monthNumber, int year);
    void printCalendar(int year);
}
