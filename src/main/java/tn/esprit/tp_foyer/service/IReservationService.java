package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Reservation;

import java.sql.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(String id);
    Reservation saveReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void removeReservation(String id);
    Reservation ajouterReservation(long idBloc,long cinEtudiant);
    Reservation annulerReservation(long cinEtudiant);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire,String nomUniversite);
}
