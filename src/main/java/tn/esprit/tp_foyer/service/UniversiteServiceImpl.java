package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.repository.FoyerRepository;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    private UniversiteRepository universiteRepository;

    private FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long id) {
        return universiteRepository.findById(id).isPresent() ? universiteRepository.findById(id).get() : null;
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer f=foyerRepository.findById(idFoyer).orElse(null);
        Universite u=universiteRepository.findByNomUniversite(nomUniversite).orElse(null);
        if(f.getUniversite() != null || u.getFoyer() != null) {
            throw new RuntimeException("Association déjà existant pour cet foyer et cette université");
        }
        u.setFoyer(f);
        f.setUniversite(u);
        universiteRepository.save(u);
        foyerRepository.save(f);
        return u;
    }

    @Override
    public Universite desaffecterFoyerUniversite(Long idUniversite) {
        Universite u=universiteRepository.findById(idUniversite).orElse(null);
        if(u.getFoyer() == null) {
            throw new RuntimeException("Aucun foyer n'est pas dans l'université");
        }
        Foyer f=u.getFoyer();
        u.setFoyer(null);
        f.setUniversite(null);
        universiteRepository.save(u);
        foyerRepository.save(f);
        return u;
    }


}
