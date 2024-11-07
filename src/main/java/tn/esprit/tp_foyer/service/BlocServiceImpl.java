package tn.esprit.tp_foyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.repository.BlocRepository;

import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService{

    BlocRepository blocRepository;

    @Override
    public List<Bloc> findAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findBlocById(Long id) {
        return blocRepository.findById(id).isPresent() ? blocRepository.findById(id).get() : null;
    }

    @Override
    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }
}
