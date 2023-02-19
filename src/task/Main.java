package task;

import task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static TaskService taskService = new TaskService();

    public static void main(String[] args) {
        lable:
        while (true) {
            taskService.menu();
            System.out.println("Выберите нужный пункт");
            if (ScannerService.scanner.hasNextInt()) {
                int cmd = 0;
                cmd = ScannerService.askInt();
                switch (cmd) {
                    case 1:
                        taskService.addTask();
                        break;
                    case 2:
                        taskService.getTaskOnData();
                        break;
                    case 3:
                        taskService.deleteTask();
                        break;
                    case 0:
                        break lable;
                    default:
                        System.out.println("Не правильно выбрали значение!");
                }
            }else ScannerService.scanner.hasNextInt();
            System.out.println("Выберите пункт из меню");
        }
        System.out.println("До встречи");
    }
}