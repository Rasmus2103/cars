package dat3.car.api;

import dat3.car.entity.Car;
import dat3.car.repository.CarsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    CarsRepository carsRepository;

    public CarController(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @GetMapping
    List<Car> getCars() {
        return carsRepository.findAll();
    }
}
