package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
