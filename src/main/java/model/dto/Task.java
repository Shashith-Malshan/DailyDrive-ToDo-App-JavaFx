package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    private String taskId;
    private String description;
    private String dateToComplete;
    private String completedDate;
    private boolean isCompleted;


}
