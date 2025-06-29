package com.spirin;

import com.spirin.model.Day;
import com.spirin.model.MonthCalendar;
import com.spirin.model.YearCalendar;
import com.spirin.service.CalendarService;
import com.spirin.service.CalendarServiceImpl;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleApp {
        private static final Logger logger = Logger.getLogger(ConsoleApp.class.getName());
        private final CalendarService calendarService = new CalendarServiceImpl();

        public static void main(String[] args) {
            new ConsoleApp().run();
        }

    private void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            int year = promptYear(scanner);
            YearCalendar yc = calendarService.generateCalendar(year);
            printYearCalendar(yc);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Произошла внутренняя ошибка", e);
            System.out.println("Что‑то пошло не так, смотрите логи для деталей.");
            System.exit(1);
        }
    }

    private int promptYear(Scanner scanner) {
        while (true) {
            System.out.print("Введите год (>= 1601): ");
            String line;
            try {
                line = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.out.println("\nВвод прерван. До новых встреч!");
                System.exit(0);
                return -1;
            }

            try {
                int year = Integer.parseInt(line);
                if (year < 1601) {
                    System.out.println("Год должен быть не менее 1601. Попробуйте ещё раз.");
                    continue;
                }
                return year;
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный формат года, пожалуйста, введите целое число. Попробуйте ещё раз.");
            }
        }
    }

        private void printYearCalendar(YearCalendar yc) {
            System.out.println("\nКалендарь на " + yc.getYear() + " год:\n");
            for (MonthCalendar mc : yc.getMonths()) {
                String monthName = mc.getMonth()
                        .getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault())
                        .toUpperCase(Locale.ROOT);
                System.out.printf("=== %s %d ===%n", monthName, mc.getYear());
                System.out.println("Пн Вт Ср Чт Пт Сб Вс");

                int offset = mc.getDays().get(0).getDayOfWeek().getValue() - 1;
                for (int i = 0; i < offset; i++) {
                    System.out.print("   ");
                }
                for (Day d : mc.getDays()) {
                    System.out.printf("%2d ", d.getDayOfMonth());
                    if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
                        System.out.println();
                    }
                }
                System.out.println("\n");
            }
        }
}