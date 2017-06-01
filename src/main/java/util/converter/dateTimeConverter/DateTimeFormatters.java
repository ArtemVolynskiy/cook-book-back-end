//package util.converter.dateTimeConverter;
//
//import org.springframework.format.Formatter;
//
//import java.text.ParseException;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;
//
///**
// * Created by Artem on 30-May-17.
// */
//public class DateTimeFormatters {
//    public static class LocalDateFormatter implements Formatter<LocalDate> {
//
//        @Override
//        public LocalDate parse(String text, Locale locale) throws ParseException {
//            return parseLocalDate(text);
//        }
//
//        @Override
//        public String print(LocalDate lt, Locale locale) {
//            return lt.format(DateTimeFormatters.ISO_LOCAL_DATE);
//        }
//    }
//
//    public static class LocalTimeFormatter implements Formatter<LocalTime> {
//
//        @Override
//        public LocalTime parse(String text, Locale locale) throws ParseException {
//            return parseLocalTime(text);
//        }
//
//        @Override
//        public String print(LocalTime lt, Locale locale) {
//            return lt.format(DateTimeFormatters.ISO_LOCAL_TIME);
//        }
//    }
//}