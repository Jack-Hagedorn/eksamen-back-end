package dtos;

import entities.ProjectHours;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectHoursDTO {
    private int hoursSpent;
    private int userStory;
    private String description;

    public ProjectHoursDTO(ProjectHours projectHours){
        this.hoursSpent = projectHours.getHoursSpent();
        this.userStory = projectHours.getUserStory();
        this.description = projectHours.getDescription();
    }
}
