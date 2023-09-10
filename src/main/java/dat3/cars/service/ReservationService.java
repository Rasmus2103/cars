package dat3.cars.service;

import dat3.cars.dto.MemberResponse;
import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repository.CarsRepository;
import dat3.cars.repository.MemberRepository;
import dat3.cars.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    CarsRepository carsRepository;
    MemberRepository memberRepository;
    ReservationRepository reservationRepository;

    public ReservationService(CarsRepository carsRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carsRepository = carsRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationResponse> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationResponse> response = reservations.stream().map(reservation -> new ReservationResponse(reservation)).toList();

        return response;
    }

    public ReservationResponse reserveCar(ReservationRequest body) {
        if(body.getDate().isBefore(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date in past not allowed");
        }
        Member member = memberRepository.findById(body.getUserName()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No member with this USERNAME is found"));

        Car car = carsRepository.findById(body.getCarId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No car with this ID is found"));

        if(reservationRepository.existsByCar_IdAndRentalDate(body.getCarId(), body.getDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This car is reserved om this date");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd"));
        //LocalDate reservationDate = LocalDate.parse(body.getDate(), formatter);


        Reservation reservation = new Reservation(body.getDate(), car, member);
        return new ReservationResponse(reservation);
    }

}
