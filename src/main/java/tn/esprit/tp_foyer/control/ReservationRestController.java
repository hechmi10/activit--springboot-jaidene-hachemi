package tn.esprit.tp_foyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Reservation;
import tn.esprit.tp_foyer.service.IReservationService;

import java.util.List;

@Tag(name="Gestion des réservations")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    IReservationService reservationService;

    //http://localhost:8089/foyer/reservations/retrieve-all-reservations
    @Operation(description="Récupérer tous les réservations")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.findAllReservations();
    }

    //http://localhost:8089/foyer/reservations/retrieve-reservation/5
    @Operation(description="Récupérer une réservation par son ID")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    //http://localhost:8089/foyer/reservations/add-reservation
    @Operation(description="Ajouter une réservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }

    //http://localhost:8089/foyer/reservation/delete-reservation/5
    @Operation(description="Supprimer une réservation")
    @DeleteMapping("/delete-reservation/{reservation-id}")
    public void deleteReservation(@PathVariable("reservation-id") String reservationId){
        reservationService.removeReservation(reservationId);
    }

    //http://localhost:8089/foyer/reservation/modify-reservation
    @Operation(description="Modifier une réservation")
    @PutMapping("/modify-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }
}
