package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Etudiant;
import tn.esprit.tp_foyer.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{

    private EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long id) {
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
    public void removeEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}
