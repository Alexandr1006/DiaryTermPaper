package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public abstract class Task{
    static int idGenerator = 0;
    private String title;
    private Type taskType;
    private final int id;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private TaskPeriodcity taskPeriodcity;

    public Task() {
        idGenerator++;
        id = idGenerator;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Task.idGenerator = idGenerator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getTaskType() {
        return taskType;
    }

    public void setTaskType(Type taskType) {
        this.taskType = taskType;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public TaskPeriodcity getTaskPeriodcity() {
        return taskPeriodcity;
    }

    public void setTaskPeriodcity(TaskPeriodcity taskPeriodcity) {
        this.taskPeriodcity = taskPeriodcity;
    }

    public void takeData(TaskPeriodcity type) {
        System.out.println("Введите заголовок");
        title = ScannerService.scanner.next();
        System.out.println("Описание задачи");
        description = ScannerService.scanner.next();
        for (Type task : Type.values()) {
            System.out.println(task);
        }
        taskType = Type.valueOf(ScannerService.scanner.next());
        try {
            System.out.println("На какую дату назначить задачу? Формат ввода даты: " + ScannerService.DATA_FORMAT);
            LocalDate date1 = ScannerService.askData();
            TaskService.cheсkData(date1);
            date = date1;
        } catch (IncorrectDateException e) {
            date = LocalDate.now();
            System.out.println(e.getMessage());
        }
        System.out.println("На какое время назначить задачу? Формат ввода времени: " + ScannerService.TIME_FORMAT);
        time = ScannerService.askTime();
        taskPeriodcity = type;


    }
    public abstract boolean appearsIn(LocalDate inputDate);
    public abstract void nextTimeRunTask();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && taskType == task.taskType && Objects.equals(description, task.description) && Objects.equals(date, task.date) && Objects.equals(time, task.time) && taskPeriodcity == task.taskPeriodcity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, taskType, id, description, date, time, taskPeriodcity);
    }

    @Override
    public String toString() {
        return id + " Тип " +
                taskType + " повторение " +
                taskPeriodcity + " Заголовок " +
                title + " описание " +
                description + " дата " +
                date + " время " + time;

    }
}