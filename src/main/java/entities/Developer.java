package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "developers")
public class Developer  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String email;
    private String phone;
    private int billingPrHour;


    public Developer(String name, String email, String phone, int billingPrHour) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.billingPrHour = billingPrHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBillingPrHour() {
        return billingPrHour;
    }

    public void setBillingPrHour(int billingPrHour) {
        this.billingPrHour = billingPrHour;
    }
}
