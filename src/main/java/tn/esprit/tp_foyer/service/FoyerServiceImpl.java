package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.repository.FoyerRepository;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{

    private final UniversiteRepository universiteRepository;
    private FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long id) {
        return foyerRepository.findById(id).isPresent() ? foyerRepository.findById(id).get() : null;
    }

    @Override
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void removeFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        Universite u=universiteRepository.findById(idUniversite).orElse(null);
        foyer.setUniversite(u);
        if(foyer.getBlocs()!=null){
            for (Bloc b : foyer.getBlocs()) {
                b.setFoyer(foyer);
            }
        }
        Foyer f = foyerRepository.save(foyer);
        u.setFoyer(f);
        universiteRepository.save(u);
        return f;
    }

}
