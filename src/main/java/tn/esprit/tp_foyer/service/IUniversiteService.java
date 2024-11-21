package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite retrieveUniversite(Long id);
    Universite saveUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void removeUniversite(Long id);
}
