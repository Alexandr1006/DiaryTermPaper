package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{

    public boolean appearsIn(LocalDate inputData){
        return inputData.equals(getDate());
    }
    public void nextTimeRunTask() {
        System.out.println("Задача активна только один раз");
    }
}
