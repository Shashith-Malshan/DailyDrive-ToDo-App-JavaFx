package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardControllerImpl implements DashboardController {

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void completeTask(Task selected, String string) {

    }

    @Override
    public void deleteTask(Task selected) {

    }

    @Override
    public ObservableList<Task> getNewTasks() {
        ObservableList<Task> tasks= FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM task WHERE isCompleted=FALSE");
            ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                tasks.add(new Task(
                        resultSet.getString("task_id"),
                        resultSet.getString("description"),
                        resultSet.getString("dateToComplete"),
                        resultSet.getString("completedDate"),
                        resultSet.getBoolean("isCompleted")
                ));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public ObservableList<Task> getCompletedTasks() {
        ObservableList<Task> tasks= FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM task WHERE isCompleted=TRUE");
            ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                tasks.add(new Task(
                        resultSet.getString("task_id"),
                        resultSet.getString("description"),
                        resultSet.getString("dateToComplete"),
                        resultSet.getString("completedDate"),
                        resultSet.getBoolean("isCompleted")
                ));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public String getLastId() {
        return "";
    }
}
