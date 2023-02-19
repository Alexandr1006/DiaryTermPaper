package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MonthlyTask extends Task{
    public boolean appearsIn(LocalDate inputData) {
        return inputData.getDayOfMonth() == getDate().getDayOfMonth();
    }
    public void nextTimeRunTask() {
        LocalDate localDate = getDate();
        long diff = ChronoUnit.MONTHS.between(localDate, LocalDate.now());
        if (diff >= 1) {
            if (LocalDate.now().getDayOfMonth() == localDate.getDayOfMonth()) {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusMonths(diff) + "\n");
            } else {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusMonths(diff + 1) + "\n");
            }
        } else {
            System.out.println("Следующая дата выполнения задачи: " + localDate.plusMonths(1) + "\n");
        }
    }
}

