package com.asrabon.todolist;

import com.asrabon.todolist.datamodel.ToDoData;
import com.asrabon.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {

    @FXML
    private ListView toDoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;

    private List<ToDoItem> todoItems;

    public void initialize() {
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(event -> {
            ToDoItem item = (ToDoItem) toDoListView.getSelectionModel().getSelectedItem();
            deleteItem(item);
        });

        listContextMenu.getItems().addAll(deleteMenuItem);
        toDoListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null) {
                ToDoItem item = (ToDoItem) toDoListView.getSelectionModel().getSelectedItem();
                itemDetailsTextArea.setText(item.getDetails());
                DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                deadlineLabel.setText(df.format(item.getDeadline()));
            }
        });

        toDoListView.setItems(ToDoData.getInstance().getToDoItems());
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();

        toDoListView.setCellFactory(new Callback<ListView<ToDoItem>, ListCell<ToDoItem>>() {
            @Override
            public ListCell<ToDoItem> call(ListView<ToDoItem> param) {
                ListCell<ToDoItem> cell = new ListCell<ToDoItem>() {
                    @Override
                    protected void updateItem(ToDoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) {
                            setText(null);
                            setContextMenu(null);
                        } else {
                            setText(item.getShortDescription());
                            setContextMenu(listContextMenu);
                            if(item.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.RED);
                            } else if(item.getDeadline().isEqual(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.GREEN);
                            }
                        }
                    }
                };
//                cell.emptyProperty().addListener (
//                    (obs, wasEmpty, isNowEmpty) -> {
//                        if(isNowEmpty) {
//                            cell.setContextMenu(null);
//                        } else {
//                            cell.setContextMenu(listContextMenu);
//                        }
//                    });
                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New ToDo Item");
        dialog.setHeaderText("Use this dialog to create a new todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("toDoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            ToDoItem newItem = controller.processResults();
            toDoListView.getSelectionModel().select(newItem);
        }
    }

    @FXML
    public void handleClickListView() {
        ToDoItem item = (ToDoItem) toDoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }

    public void deleteItem(ToDoItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete ToDo Item");
        alert.setHeaderText("Delete Item: " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && (result.get() == ButtonType.OK)) {
            ToDoData.getInstance().deleteToDoItem(item);
        }
    }

}
