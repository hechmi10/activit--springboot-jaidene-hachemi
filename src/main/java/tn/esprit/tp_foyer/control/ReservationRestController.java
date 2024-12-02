package tn.esprit.tp_foyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Reservation;
import tn.esprit.tp_foyer.service.IReservationService;

import java.sql.Date;
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
        return reservationService.retrieveAllReservations();
    }

    //http://localhost:8089/foyer/reservations/retrieve-reservation/5
    @Operation(description="Récupérer une réservation par son ID")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    //http://localhost:8089/foyer/reservations/add-reservation
    @Operation(description="Ajouter une réservation")
    @PostMapping("/save-reservation")
    public Reservation saveReservation(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }

    //http://localhost:8089/foyer/reservation/delete-reservation/5
    @Operation(description="Supprimer une réservation")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String reservationId){
        reservationService.removeReservation(reservationId);
    }

    //http://localhost:8089/foyer/reservation/modify-reservation
    @Operation(description="Modifier une réservation")
    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    @Operation(description="Ajouter une réservation")
    @PostMapping("/ajouter-reservation/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable("idBloc") Long idBloc,@PathVariable("cinEtudiant") Long cinEtudiant){
        return reservationService.ajouterReservation(idBloc, cinEtudiant);
    }

    @Operation(description="Annuler une réservation")
    @PostMapping("/annuler-reservation/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable("cinEtudiant") Long cinEtudiant){
        return reservationService.annulerReservation(cinEtudiant);
    }

    @Operation(description="Récupérer des réservations par leur année universitaire et nom de leur université")
    @GetMapping("getReservationParAnneeUniversitaireEtNomUniversite/{anneeUniversitaire}/{nomUniversite}")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@PathVariable("anneeUniversitaire") Date anneeUniversitaire, @PathVariable("nomUniversite") String nomUniversite){
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }
}
