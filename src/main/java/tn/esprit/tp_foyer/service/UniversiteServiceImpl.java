package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    private UniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long id) {
        return universiteRepository.findById(id).isPresent() ? universiteRepository.findById(id).get() : null;
    }

    @Override
    public Universite saveUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void removeUniversite(Long id) {
        universiteRepository.deleteById(id);
    }
}
