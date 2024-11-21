package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant retrieveEtudiant(Long id);
    Etudiant updateEtudiant(Etudiant et);
    void removeEtudiant(Long id);

}
