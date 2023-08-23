package dat3.car.repository;

import dat3.car.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarsRepositoryTest {

    @Autowired
    CarsRepository carsRepository;
    boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if(!isInitialized) {
            carsRepository.deleteAll();
            carsRepository.save(new Car("Toyota", "Camry", 500, 10));
            carsRepository.save(new Car("Tesla", "Model3", 700, 15));
            isInitialized = true;
        }
    }

    @Test
    public void deleteAll() {
        carsRepository.deleteAll();
        assertEquals(0, carsRepository.count());
    }
}