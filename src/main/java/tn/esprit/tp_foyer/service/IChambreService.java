package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre retrieveChambre(Long id);
    Chambre createChambre(Chambre c);
    Chambre updateChambre(Chambre c,Long id);
    void removeChambre(Long id);
}
