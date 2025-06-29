package com.spirin.service;

import com.spirin.model.Day;
import com.spirin.model.MonthCalendar;
import com.spirin.model.YearCalendar;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CalendarServiceImpl implements CalendarService {

    @Override
    public YearCalendar generateCalendar(int year) {
        List<MonthCalendar> months = new ArrayList<>();

        for (Month m : Month.values()) {
            List<Day> days = new ArrayList<>();
            boolean isLeap = LocalDate.of(year, m, 1).isLeapYear();
            int length = m.length(isLeap);
            for (int d = 1; d <= length; d++) {
                LocalDate date = LocalDate.of(year, m, d);
                days.add(new Day(d, date.getDayOfWeek()));
            }
            months.add(
                    new MonthCalendar(
                            m,
                            year,
                            days
                    )
            );
        }
        return new YearCalendar(year, months);
    }
}
