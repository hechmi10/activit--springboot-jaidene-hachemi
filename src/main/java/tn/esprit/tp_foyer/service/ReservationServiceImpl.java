package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Etudiant;
import tn.esprit.tp_foyer.entity.Reservation;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.EtudiantRepository;
import tn.esprit.tp_foyer.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{

    private final BlocRepository blocRepository;
    private final EtudiantRepository etudiantRepository;
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }


    @Override
    public Reservation retrieveReservation(String id) {
        return reservationRepository.findById(id).isPresent() ? reservationRepository.findById(id).get() : null;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc b = blocRepository.findById(idBloc).orElse(null);
        Etudiant e=etudiantRepository.findById(cinEtudiant).orElse(null);
        return null;
    }
}
