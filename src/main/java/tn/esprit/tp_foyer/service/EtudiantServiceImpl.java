package tn.esprit.tp_foyer.service;

import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Etudiant;
import tn.esprit.tp_foyer.repository.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService{

    EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiantById(Long id) {
        return etudiantRepository.findById(id).isPresent() ? etudiantRepository.findById(id).get() : null;
    }

    @Override
    public Etudiant createEtudiant(Etudiant et) {
        return etudiantRepository.save(et);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return etudiantRepository.save(et);
    }

    @Override
    public void deleteEtudiantById(Long id) {
        etudiantRepository.deleteById(id);
    }
}
