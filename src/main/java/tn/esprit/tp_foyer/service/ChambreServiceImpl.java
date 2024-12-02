package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.entity.TypeChambre;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{

    private ChambreRepository chambreRepository;

    private BlocRepository blocRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long id) {
        return chambreRepository.findById(id).isPresent() ? chambreRepository.findById(id).get() : null;
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    //Keyword
    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc, typeC);
    }

    //JPQL
    //@Override
    //public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
    //    return chambreRepository.getChambresParBlocEtType(idBloc,typeC);
    //}

}
