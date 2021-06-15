package dtos;

import entities.Developer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeveloperDTO {

    private String name;
    private String email;
    private String phone;

    public DeveloperDTO(Developer developer){
        this.name = developer.getName();
        this.email = developer.getEmail();
        this.phone = developer.getPhone();
    }
}
