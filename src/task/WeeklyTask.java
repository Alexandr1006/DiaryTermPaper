package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class WeeklyTask extends Task {
    public boolean appearsIn(LocalDate inputData, LocalDate taskData) {
        return inputData.getDayOfWeek() == taskData.getDayOfWeek();
    }
    public void nextTimeRunTask() {
        LocalDate localDate = getDate();
        long diff = ChronoUnit.WEEKS.between(localDate, LocalDate.now());
        if (diff >= 1) {
            if (localDate.getDayOfWeek() == LocalDate.now().getDayOfWeek()) {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusWeeks(diff) + "\n");
            } else {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusWeeks(diff + 1) + "\n");
            }
        } else {
            System.out.println("Следующая дата выполнения задачи: " + localDate.plusWeeks(1) + "\n");
        }
    }
}