package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> findAllReservations();
    Reservation retrieveReservation(String id);
    Reservation saveReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation,String id);
    void removeReservation(String id);
}
