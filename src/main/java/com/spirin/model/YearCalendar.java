package com.spirin.model;

import java.util.List;

public class YearCalendar {
    private final int year;
    private final List<MonthCalendar> months;

    public YearCalendar(int year, List<MonthCalendar> months) {
        this.year = year;
        this.months = months;
    }

    public int getYear() {
        return year;
    }

    public List<MonthCalendar> getMonths() {
        return months;
    }
}