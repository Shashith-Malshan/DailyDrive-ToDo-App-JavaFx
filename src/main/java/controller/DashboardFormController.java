package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Task;

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
    private TableView<Task> tblCompleted;

    @FXML
    private TableView<Task> tblNewTask;

    @FXML
    private TextField txtEnterTask;

    @FXML
    void addTaskOnAction(ActionEvent event) {

        Task task=new Task(generateNextId(getLastId()), txtEnterTask.getText(), dateToComplete.getValue().toString(), null, false);

        dashboardController.addTask(task);


    }

    @FXML
    void completedOnAction(ActionEvent event) {
        Task selected = (Task) tblNewTask.getSelectionModel().getSelectedItem();
        dashboardController.completeTask(selected,completedDate.getValue().toString());

    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        Task selected= (Task) tblCompleted.getSelectionModel().getSelectedItem();
        dashboardController.deleteTask(selected);

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
