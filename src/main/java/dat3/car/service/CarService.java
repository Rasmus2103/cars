package dat3.car.service;

import dat3.car.dto.CarDTO;
import dat3.car.dto.MemberRequest;
import dat3.car.dto.MemberResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

    CarsRepository carsRepository;

    public CarService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<CarDTO> getCars(boolean includeAll) {
        List<Car> cars = carsRepository.findAll();
        List<CarDTO> carDTOS = cars.stream().map(car -> new CarDTO(car, includeAll)).toList();
        return carDTOS;
    }

    public CarDTO addCar(CarDTO body) {
        if(carsRepository.existsById(body.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This user already exists");
        }

        Car newCar = CarDTO.getCarEntity(body);

        newCar = carsRepository.save(newCar);
        return new CarDTO(newCar, true);
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

    public CarDTO findCarById(int id) {
        Car car = getCarById(id);
        return new CarDTO(car, true);
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
