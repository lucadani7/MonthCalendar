package com.lucadani.calendar;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MonthCalendar implements MonthCalendarInterface {
    @Override
    public boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    @Override
    public int dayNumber(int day, int month, int year) {
        int[] array = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) {
            --year;
        }
        return (year + year / 4 - year / 100 + year / 400 + array[month - 1] + day) % 7;
    }

    @Override
    public String getMonthName(int monthNumber) {
        List<Year> monthList = new ArrayList<>(EnumSet.allOf(Year.class));
        if (monthNumber > monthList.size()) {
            return "Wrong number!";
        }
        return String.valueOf(monthList.get(monthNumber));
    }

    @Override
    public int numberOfDays(int monthNumber, int year) {
        return switch (monthNumber) {
            case 0, 2, 4, 6, 7, 9, 11 -> 31; // January, March, May, July, August, October, December
            case 3, 5, 8, 10 -> 30; // April, June, September, November
            default -> isLeapYear(year) ? 29 : 28; // February
        };
    }

    @Override
    public void printCalendar(int year) {
        System.out.printf("     Calendar - %d\n\n", year);
        int current = dayNumber(1, 1, year);
        for (int i = 0; i < 12; ++i) {
            int days = numberOfDays(i, year);
            System.out.printf("\n ------------%s-------------\n", getMonthName(i));
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
            int k;
            for (k = 0; k < current; ++k) {
                System.out.print("     ");
            }
            for (int j = 1; j <= days; ++j) {
                System.out.printf("%5d", j);
                if (++k > 6) {
                    k = 0;
                    System.out.println();
                }
            }
            if (k != 0) {
                System.out.println();
            }
            current = k;
        }
    }
}
