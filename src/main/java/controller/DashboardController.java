package controller;

import javafx.collections.ObservableList;
import model.dto.Task;

public interface DashboardController {
    void addTask(Task task);

    void completeTask(Task selected, String string);

    void deleteTask(Task selected);

    ObservableList<Task> getNewTasks();

    ObservableList<Task> getCompletedTasks();

    String getLastId();
}
