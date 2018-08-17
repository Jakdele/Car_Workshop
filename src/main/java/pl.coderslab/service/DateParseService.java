package pl.coderslab.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateParseService {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Date stringToDate(String possibleDate) {
        try {
            if (possibleDate != null) {
                Date date = dateFormat.parse(possibleDate);
                return date;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToString(Date date) {
        try {
            if (date != null) {
                String newString = dateFormat.format(date);
                return newString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static LocalDate stringToLocalDate(String possibleDate) {
        try {
            if (possibleDate != null) {
                LocalDate date = LocalDate.parse(possibleDate);
                return date;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String localDateToString(LocalDate date) {
        try {
            if (date != null) {
                String newString = date.format(formatter);
                return newString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
