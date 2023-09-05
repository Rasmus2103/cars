package dat3.car.api;

import dat3.car.dto.CarDTO;
import dat3.car.entity.Car;
import dat3.car.repository.CarsRepository;
import dat3.car.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    List<CarDTO> getCars() {
        return carService.getCars(false);
    }
}
