package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    DashboardController dashboardController=new DashboardControllerImpl();

    @FXML
    private DatePicker completedDate;

    @FXML
    private Button btnAddTask;

    @FXML
    private Button btnCompleted;

    @FXML
    private Button btnDelete;

    @FXML
    private TableColumn<?, ?> colCompetedTask;

    @FXML
    private TableColumn<?, ?> colCompletedDate;

    @FXML
    private TableColumn<?, ?> colDateToComplete;

    @FXML
    private TableColumn<?, ?> colNewTask;

    @FXML
    private DatePicker dateToComplete;

    @FXML
    private TableView<?> tblCompleted;

    @FXML
    private TableView<?> tblNewTask;

    @FXML
    private TextField txtEnterTask;

    @FXML
    void addTaskOnAction(ActionEvent event) {


    }

    @FXML
    void completedOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
