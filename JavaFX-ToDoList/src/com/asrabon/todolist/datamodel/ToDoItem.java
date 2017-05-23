package com.asrabon.todolist.datamodel;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Created by Sloan on 5/15/2017.
 */
public class ToDoItem implements Comparator<ToDoItem> {
    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public ToDoItem(String shortDescription, String details, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public int compare(ToDoItem o1, ToDoItem o2) {
        return 0;
    }

}
