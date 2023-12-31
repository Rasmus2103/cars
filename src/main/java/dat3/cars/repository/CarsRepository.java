package dat3.cars.repository;

import dat3.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Car, Integer> {
    Car findByBrand(String brand);
}
