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
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String username;

    @Column(name = "email", length = 60, nullable = false)
    String email;

    @Column(name = "password", length = 70, nullable = false)
    String password;

    @Column(name = "firstname", length = 40, nullable = false)
    String firstName;

    @Column(name = "lastname", length = 40, nullable = false)
    String lastName;

    @Column(name = "street", length = 60, nullable = false)
    String street;

    @Column(name = "city", length = 60, nullable = false)
    String city;

    @Column(name = "zip", length = 60, nullable = false)
    String zip;

    @Column(name = "approved")
    boolean approved;

    @Column(name = "ranking")
    int ranking;

    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime lastEdited;

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
