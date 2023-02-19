package task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScannerService{

    public static final String TIME_FORMAT = "HH:mm";
    public static final String DATA_FORMAT = "dd.MM.yyyy";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATA_FORMAT);

    public static Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public static String askStr(){

        return scanner.next();
    }
    public static int askInt(){
        return scanner.nextInt();
    }
    public static LocalTime askTime(){
        var time = scanner.next();
        return LocalTime.parse(time, TIME_FORMATTER);
    }
    public static LocalDate askData() throws IncorrectDateException{
        var data = scanner.next();
        return LocalDate.parse(data, DATE_FORMATTER);
    }
}
