package dat3.cars.api;

import dat3.cars.dto.ReservationResponse;
import dat3.cars.service.ReservationService;
import dat3.cars.dto.ReservationRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    List<ReservationResponse> getReservations() {
        return reservationService.getReservations();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ReservationResponse makeReservation(@RequestBody ReservationRequest res) {
        return reservationService.reserveCar(res);
    }
}
