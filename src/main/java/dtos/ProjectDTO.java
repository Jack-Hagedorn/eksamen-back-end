package dtos;

import entities.Project;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDTO {
    private String name;
    private String description;

    public ProjectDTO(Project project){
        this.name = project.getName();
        this.description = project.getDescription();
    }
}
