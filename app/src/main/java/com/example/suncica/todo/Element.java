package com.example.suncica.todo;


/**
 * Created by Suncica on 10/20/2016.
 */
public class Element {

    private String toDoTask;
    private String taskDescription;
    private Boolean taskDone;
    private String color;


    public Element(String toDoTask, String taskDescription, boolean taskDone, String color) {
        this.taskDescription = taskDescription;
        this.toDoTask = toDoTask;
        this.taskDone = taskDone;
        this.color = color;
    }

    public Element() {
    }

    public String getToDoTask() {
        return toDoTask;
    }

    public Boolean getTaskDone() {
        return taskDone;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getColor() {
        return color;
    }
}
