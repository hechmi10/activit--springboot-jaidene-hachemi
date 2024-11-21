package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(Long id);
    Etudiant createEtudiant(Etudiant et);
    Etudiant updateEtudiant(Etudiant et,Long id);
    void removeEtudiant(Long id);

}
