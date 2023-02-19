package task;

import task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static task.ScannerService.DATE_FORMATTER;
import static task.ScannerService.DATA_FORMAT;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final ArrayList<Task> deleteTasks = new ArrayList<>();

    public void addTask() {
        System.out.println("Выберите переодичность задачи: \n" + "1 - разовая \n" +
                "2 - ежедневная \n" +
                "3 - еженедельная \n" +
                "4 - ежемесячная \n" +
                "5 - ежегодная");
        if (ScannerService.scanner.hasNextInt()) {
            int a = ScannerService.scanner.nextInt();
            switch (a) {
                case 1:
                    TaskPeriodcity type1 = TaskPeriodcity.ONETIME;
                    var task1 = type1.newTask();
                    task1.takeData(type1);
                    taskMap.put(task1.getId(), task1);
                    System.out.println("Была создана задача: " + task1 + "\n");
                    break;
                case 2:
                    TaskPeriodcity type2 = TaskPeriodcity.DAILY;
                    var task2 = type2.newTask();
                    task2.takeData(type2);
                    taskMap.put(task2.getId(), task2);
                    System.out.println("Была создана задача: " + task2 + "\n");
                    break;
                case 3:
                    TaskPeriodcity type3 = TaskPeriodcity.WEEKLY;
                    var task3 = type3.newTask();
                    task3.takeData(type3);
                    taskMap.put(task3.getId(), task3);
                    System.out.println("Была создана задача: " + task3 + "\n");
                    break;
                case 4:
                    TaskPeriodcity type4 = TaskPeriodcity.MONTHLY;
                    var task4 = type4.newTask();
                    task4.takeData(type4);
                    taskMap.put(task4.getId(), task4);
                    System.out.println("Была создана задача: " + task4 + "\n");
                    break;
                case 5:
                    TaskPeriodcity type5 = TaskPeriodcity.YEARLY;
                    var task5 = type5.newTask();
                    task5.takeData(type5);
                    taskMap.put(task5.getId(), task5);
                    System.out.println("Была создана задача: " + task5 + "\n");
                    break;
                default:
                    System.out.println("Нет такого типа");
            }
        }

    }

    public void menu() {
        System.out.println("Добрый день, какая задача требуется? \n " +
                "1 - Создать запись \n " +
                "2 - Задачи на день \n " +
                "3 - Удалить задачу \n " +
                "0 - Выход");
    }

    public static void cheсkData(LocalDate localDate) throws IncorrectDateException {
        if (localDate.isBefore(LocalDate.now())) {
            throw new IncorrectDateException("Введена неактуальная дата. Задаче будет присвоена текущая дата!");
        }
    }

    public void getTaskOnData() {
        System.out.println("На какое число вывести задачи?");
        LocalDate localDate = inputData();
        if (taskMap.size() == 0) {
            System.out.println("В списке ничего нет");
        }
        for (Map.Entry<Integer, Task> value : taskMap.entrySet()) {
            LocalDate taskDate = value.getValue().getDate();
            if (taskDate.equals(localDate) || value.getValue().appearsIn(localDate, taskDate)) {
                System.out.println(value);
            }
        }
    }
        public LocalDate inputData() {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println(DATA_FORMAT);
            var data = scanner1.next();
            return LocalDate.parse(data, DATE_FORMATTER);
        }
    public void deleteTask(){
        try {
            System.out.println("Введите номер задачи, которую нужно удалить");
            int id = ScannerService.askInt();
            checkTaskId(id);
            Task task = taskMap.get(id);
            deleteTasks.add(task);
            System.out.println("Задача " + task + " перемещена в список удаленных");
            taskMap.remove(id);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public  void checkTaskId(int id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("!!! в списке нет задачи под номером - " + id + ", попробуйте еще раз!!!\n");
        }
    }
    }
