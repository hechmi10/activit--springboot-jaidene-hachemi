package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.repository.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{

    private BlocRepository blocRepository;

    @Override
    public List<Bloc> findAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long id) {
        return blocRepository.findById(id).isPresent() ? blocRepository.findById(id).get() : null;
    }

    @Override
    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc,Long id) {
        if(bloc.getIdBloc()==id) {
            return blocRepository.save(bloc);
        }
        return null;
    }

    @Override
    public void removeBloc(Long id) {
        blocRepository.deleteById(id);
    }
}
