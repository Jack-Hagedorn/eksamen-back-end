package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class ProjectHours implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int hoursSpent;
    private int userStory;
    private String description;

    @ManyToMany()
    private List<Developer> records;

    @ManyToMany()
    private List<Project> billedBy;

    public ProjectHours(int hoursSpent, int userStory, String description) {
        this.hoursSpent = hoursSpent;
        this.userStory = userStory;
        this.description = description;
    }

    public int getHoursSpent() {
        return hoursSpent;
    }

    public void setHoursSpent(int hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public int getUserStory() {
        return userStory;
    }

    public void setUserStory(int userStory) {
        this.userStory = userStory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
