package com.spirin.model;

import java.time.DayOfWeek;

public class Day {
    private final int dayOfMonth;
    private final DayOfWeek dayOfWeek;

    public Day(int dayOfMonth, DayOfWeek dayOfWeek) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}