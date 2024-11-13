package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> findAllFoyers();
    Foyer findFoyerById(Long id);
    Foyer saveFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer,Long id);
    void deleteFoyer(Long id);
}
