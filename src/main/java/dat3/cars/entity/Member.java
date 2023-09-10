package dat3.cars.entity;

import dat3.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles {
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

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    List<Reservation> reservations;

    public void addReservation(Reservation reservation) {
        if(reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }

    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        super(user, password, email);
//        this.username = user;
//        this.password= password;
//        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;

    }
}
