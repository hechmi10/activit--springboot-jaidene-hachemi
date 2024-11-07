package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{

    private FoyerRepository foyerRepository;

    @Override
    public List<Foyer> findAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findFoyerById(Long id) {
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
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

}
