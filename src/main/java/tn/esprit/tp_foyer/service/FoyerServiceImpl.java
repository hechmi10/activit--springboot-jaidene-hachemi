package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.repository.FoyerRepository;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.util.List;

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
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        if(foyer.getBlocs()!=null) {
            throw new RuntimeException("Foyer déja ajouté et affecté a cet université");
        }
        for(Bloc b : foyer.getBlocs()) {
            b.setFoyer(foyer);
        }
        foyer.setUniversite(u);
        foyerRepository.save(foyer);
        return foyer;

    }

}
