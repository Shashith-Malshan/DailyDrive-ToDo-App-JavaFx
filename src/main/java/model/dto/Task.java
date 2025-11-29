package model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Task {
    private String taskId;
    private String description;
    private String dateToComplete;
    private String completedDate;
    private boolean isCompleted;


}
