package dat3.service;

import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarsRepository;
import dat3.cars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarServiceTest {

    @Autowired
    CarsRepository carsRepository;
    CarService carService;

    Car c1, c2;

    @BeforeEach
    void setUp() {
        c1 = carsRepository.save(new Car("Tesla", "Model 3", 500, 10));
        c2 = carsRepository.save(new Car("Citroen", "C3", 350, 20));
        carService = new CarService(carsRepository);
    }

    @Test
    void testFindCarByBrand() {
        CarResponse c3 = carService.findCarByVBrand(c1.getBrand());
        assertEquals(c1.getBrand(), c3.getBrand());
    }
}