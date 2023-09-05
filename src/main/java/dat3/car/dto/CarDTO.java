package dat3.car.dto;

import dat3.car.entity.Car;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;
    private double pricePrDay;
    private Integer bestDiscount;

    public static Car getCarEntity(CarDTO carDTO) {
        return new Car(carDTO.brand, carDTO.model, carDTO.pricePrDay, carDTO.bestDiscount);
    }

    public CarDTO(Car car, boolean includeAll) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
    }
}

