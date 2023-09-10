package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

    CarsRepository carsRepository;

    public CarService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<CarResponse> getCars(boolean includeAll) {
        List<Car> cars = carsRepository.findAll();
        List<CarResponse> carDTOS = cars.stream().map(car -> new CarResponse(car, includeAll)).toList();
        return carDTOS;
    }

    public CarResponse addCar(CarRequest body) {
        if(carsRepository.existsById(body.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This user already exists");
        }

        Car newCar = CarRequest.getCarEntity(body);

        newCar = carsRepository.save(newCar);
        return new CarResponse(newCar, true);
    }

//    public ResponseEntity<Boolean> editCar(CarDTO body, int id) {
//        Car car = getCarById(id);
//        if(!body.getId(){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change ID");
//        }
//        car.setBrand(body.getBrand());
//        car.setModel(body.getModel());
//        car.setPricePrDay(body.getPricePrDay());
//        car.setBestDiscount(body.getBestDiscount());
//        return ResponseEntity.ok(true);
//    }


    public CarResponse findCarByVBrand(String brand) {
        Car car = carsRepository.findByBrand(brand);
        return new CarResponse(car, true);
    }

    public void deleteCarById(int id) {
        Car car = getCarById(id);
        carsRepository.delete(car);
    }

    private Car getCarById(int id) {
        return carsRepository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car with this ID does not exist"));
    }

}
