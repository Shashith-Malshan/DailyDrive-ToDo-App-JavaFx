package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Task;

import java.net.URL;
import java.util.List;
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
    private TableView<Task> tblCompleted;

    @FXML
    private TableView<Task> tblNewTask;

    @FXML
    private TextField txtEnterTask;

    @FXML
    void addTaskOnAction(ActionEvent event) {

        if(dateToComplete.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();

        }else {
            Task task=new Task(generateNextId(getLastId()), txtEnterTask.getText(), dateToComplete.getValue().toString(), null, false);

            dashboardController.addTask(task);
            txtEnterTask.clear();
            dateToComplete.setValue(null);
            loadNewTasks();
        }
    }

    @FXML
    void completedOnAction(ActionEvent event) {

        if(dateToComplete.getValue()==null){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please select the completed date.");
            alert.showAndWait();


        }else{
            Task selected = (Task) tblNewTask.getSelectionModel().getSelectedItem();
            dashboardController.completeTask(selected,completedDate.getValue().toString());

            loadNewTasks();
            loadCompletedTasks();
            completedDate.setValue(null);
        }
    }

    @FXML
    void deleteOnAction(ActionEvent event) {

        Task selected= (Task) tblCompleted.getSelectionModel().getSelectedItem();
        dashboardController.deleteTask(selected);
        loadCompletedTasks();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNewTask.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDateToComplete.setCellValueFactory(new PropertyValueFactory<>("dateToComplete"));

        colCompetedTask.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCompletedDate.setCellValueFactory(new PropertyValueFactory<>("completedDate"));

        loadNewTasks();
        loadCompletedTasks();


    }

    @FXML
    void loadNewTasks(){

        tblNewTask.setItems(dashboardController.getNewTasks());


    }

    void loadCompletedTasks(){
        tblCompleted.setItems(dashboardController.getCompletedTasks());

    }

    String getLastId(){
        System.out.println(dashboardController.getLastId());
        return dashboardController.getLastId();
    }
    String generateNextId(String lastId){

        if (lastId == null || lastId.isEmpty()) {
            return "T001";
        }

        int number = Integer.parseInt(lastId.substring(1));
        number++;

        return String.format("T%03d", number);
    }


}
