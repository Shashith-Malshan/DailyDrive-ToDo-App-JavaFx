package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DashboardFormController {

    @FXML
    private Button btnAddTask;

    @FXML
    private Button btnCompleted;

    @FXML
    private Button btnDeleted;

    @FXML
    private CheckBox cardToDoTask;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colTask;

    @FXML
    private DatePicker datetoComplete;

    @FXML
    private TableView<?> tblCompleted;

    @FXML
    private TextField txtEnterTask;

    @FXML
    private TextField txtId;

    @FXML
    void addTaskOnAction(ActionEvent event) {

    }

    @FXML
    void completedOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

}
