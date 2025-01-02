package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.*;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;
import tn.esprit.tp_foyer.repository.EtudiantRepository;
import tn.esprit.tp_foyer.repository.ReservationRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{

    private final BlocRepository blocRepository;
    private final EtudiantRepository etudiantRepository;
    private final ChambreRepository chambreRepository;
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
        Etudiant e=etudiantRepository.findByCin(cinEtudiant).orElse(null);
        assert b != null;
        Chambre c = b.getChambres().stream()
                .filter(ch -> ch.getReservation().size() < getCapaciteMaximale(ch.getTypeC()))
                .findFirst().orElse(null);

        if (c==null) {
            throw new RuntimeException("Aucune chambre disponible pour ce bloc");
        }


        Reservation r= new Reservation();
        r.setIdReservation(c.getNumeroChambre()+"-"+b.getNomBloc()+"-"+r.getAnneeUniversitaire());
        r.setEstValide(true);
        r.getEtudiants().add(e);
        c.getReservation().add(r);
        reservationRepository.save(r);
        chambreRepository.save(c);
        return r;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e=etudiantRepository.findByCin(cinEtudiant).orElse(null);
        assert e != null;
        Reservation r = e.getReservations().stream()
                .filter(Reservation::getEstValide)
                .findFirst()
                .orElse(null);

        assert r != null;
        r.setEstValide(false);

        r.getEtudiants().remove(e);

        Chambre chambreAssociee = chambreRepository.findAll().stream()
                .filter(chambre -> chambre.getReservation().contains(r))
                .findFirst()
                .orElse(null);

        assert chambreAssociee != null;
        chambreAssociee.getReservation().remove(r);

        reservationRepository.save(r);
        chambreRepository.save(chambreAssociee);

        return r;

    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findByAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }



    public int getCapaciteMaximale(TypeChambre typeChambre) {
        switch (typeChambre) {
            case SIMPLE:
                return 1;
            case DOUBLE:
                return 2;
            case TRIPLE:
                return 3;
            default:
                throw new RuntimeException("Type de chambre non valide");
        }
    }

}
