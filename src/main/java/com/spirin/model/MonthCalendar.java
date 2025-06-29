package com.spirin.model;

import java.time.Month;
import java.util.List;

public class MonthCalendar {
    private final Month month;
    private final int year;
    private final List<Day> days;

    public MonthCalendar(Month month, int year, List<Day> days) {
        this.month = month;
        this.year = year;
        this.days = days;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public List<Day> getDays() {
        return days;
    }
}
