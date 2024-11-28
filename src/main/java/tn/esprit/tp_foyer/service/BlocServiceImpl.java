package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{

    private ChambreRepository chambreRepository;
    private BlocRepository blocRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long id) {
        return blocRepository.findById(id).isPresent() ? blocRepository.findById(id).get() : null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void removeBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Bloc b=blocRepository.findById(idBloc).orElse(null);
        Set<Chambre> cList=chambreRepository.findAllByNumeroChambre(numChambres);
        if(cList.size()!=numChambres.size()){
            throw new RuntimeException("Une ou plusieurs chambres sont introuvables");
        }
        for(Chambre c:cList){
            if(c.getBloc()!=null || c.getBloc().getIdBloc()!=idBloc) {
                throw new RuntimeException("Le chambre "+c.getNumeroChambre()+" est déjà affecté dans le bloc");
            }
        }
        for(Chambre c:cList){
            c.setBloc(b);
        }
        b.getChambres().addAll(cList);
        blocRepository.save(b);
        chambreRepository.saveAll(cList);
        return b;
    }
}
