package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.entity.TypeChambre;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{

    private final UniversiteRepository universiteRepository;
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
    //    return chambreRepository.getChambresParBlocEtTypeC(idBloc,typeC);
    //}

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite u=universiteRepository.findByNomWithFoyerAndBlocs(nomUniversite);
        if(u==null){
            throw new RuntimeException("Universite non existante");
        }
        if(u.getFoyer()==null){
            throw new RuntimeException("Foyer non existante");
        }
        return u.getFoyer().getBlocs().stream().flatMap(bloc->bloc.getChambres().stream()).collect(Collectors.toList());
    }

    @Override
    public List<Chambre> getChambreNonReservesParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre typeC) {
        Date currentYear = new Date(System.currentTimeMillis());
        return chambreRepository.findChambresNonReserveParNomUniversiteEtTypeC(nomUniversite,typeC,currentYear);
    }


}
