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
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO task(task_id,description,dateToComplete,isCompleted) VALUES (?,?,?,?)");
            preparedStatement.setObject(1,task.getTaskId());
            preparedStatement.setObject(2,task.getDescription());
            preparedStatement.setObject(3,task.getDateToComplete());
            preparedStatement.setObject(4,false);

            preparedStatement.execute();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void completeTask(Task task,String completedDate) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("UPDATE task SET completedDate=?,isCompleted=? WHERE task_id=?");
            preparedStatement.setObject(1,completedDate);
            preparedStatement.setBoolean(2,true);
            preparedStatement.setObject(3,task.getTaskId());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT task_id FROM task ORDER BY task_id DESC LIMIT 1");
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("task_id");
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
