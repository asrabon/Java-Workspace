package com.asrabon.todolist;

import com.asrabon.todolist.datamodel.ToDoData;
import com.asrabon.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;


/**
 * Created by Sloan on 5/16/2017.
 */
public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public ToDoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineDate = deadlinePicker.getValue();

        ToDoItem newItem = new ToDoItem(shortDescription, details, deadlineDate);
        ToDoData.getInstance().addToDoItem(newItem);
        return newItem;
    }


}
