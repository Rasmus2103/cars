package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Member extends AdminDetails{
    @Id
    String username;

    @Column(name = "email", length = 60)
    String email;

    @Column(name = "password", length = 70)
    String password;

    @Column(name = "firstname", length = 40)
    String firstName;

    @Column(name = "lastname", length = 40)
    String lastName;

    @Column(name = "street", length = 60)
    String street;

    @Column(name = "city", length = 60)
    String city;

    @Column(name = "zip", length = 60)
    String zip;

    @Column(name = "approved")
    boolean approved;

    @Column(name = "ranking")
    int ranking;

    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        this.username = user;
        this.password= password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;

    }
}
