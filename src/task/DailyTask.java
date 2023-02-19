package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public boolean appearsIn(LocalDate inputData) {
        return true;
    }

    public void nextTimeRunTask() {
        System.out.println("Следующая дата выполнения задачи: " + LocalDate.now().plusDays(1) + "\n");
    }
}


