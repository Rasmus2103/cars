package dat3.cars.entity;

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
public class Car extends AdminDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "car_brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "car_model", length = 60, nullable = false)
    String model;

    @Column(name = "rental_price_day")
    double pricePrDay;

    @Column(name = "max_discount")
    Integer bestDiscount;

    @OneToMany(mappedBy = "car")
    List<Reservation> reservations;

    public void addReservation(Reservation reservation) {
        if(reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }

    public Car(String brand, String model, double pricePrDay, Integer bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

}
