package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();
    Bloc retrieveBloc(Long id);
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void removeBloc(Long id);
    Bloc affecterChambresABloc(List<Long> numChambre,long idBloc);
}
