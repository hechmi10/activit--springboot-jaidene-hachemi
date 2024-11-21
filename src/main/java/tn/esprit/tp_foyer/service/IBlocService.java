package tn.esprit.tp_foyer.service;

import tn.esprit.tp_foyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc retrieveBloc(Long id);
    Bloc saveBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void removeBloc(Long id);
}
