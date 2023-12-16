package com.lucadani;

import com.lucadani.calendar.MonthCalendar;
import com.lucadani.calendar.MonthCalendarInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MonthCalendarInterface monthCalendar = new MonthCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a year: ");
        int year = scanner.nextInt();
        monthCalendar.printCalendar(year);
    }
}