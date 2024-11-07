package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiantById(Long id);
    Etudiant createEtudiant(Etudiant et);
    Etudiant updateEtudiant(Etudiant et);
    void deleteEtudiantById(Long id);

}
