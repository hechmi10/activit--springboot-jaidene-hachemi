package tn.esprit.tp_foyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Reservation;
import tn.esprit.tp_foyer.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    IReservationService reservationService;

    //http://localhost:8089/foyer/reservations/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.findAllReservations();
    }

    //http://localhost:8089/foyer/reservations/retrieve-reservation/5
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.findReservationById(reservationId);
    }

    //http://localhost:8089/foyer/reservations/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }

    //http://localhost:8089/foyer/reservation/delete-reservation/5
    @DeleteMapping("/delete-reservation/{reservation-id}")
    public void deleteReservation(@PathVariable("reservation-id") String reservationId){
        reservationService.deleteReservationById(reservationId);
    }

    //http://localhost:8089/foyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }
}
