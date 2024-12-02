package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;

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
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc) {
        Bloc b=blocRepository.findById(idBloc).orElse(null);
        Set<Chambre> chambres=chambreRepository.findAllByNumeroChambreIn(numChambres);
        if(chambres.size()!=numChambres.size()){
            throw new RuntimeException("Une ou plusieurs chambres sont introuvables");
        }
        for(Chambre c:chambres){
            if(c.getBloc()!=null && c.getBloc().getIdBloc()!=idBloc) {
                throw new RuntimeException("Le chambre "+c.getNumeroChambre()+" est déjà affecté dans un autre bloc");
            }
        }
        for(Chambre c:chambres){
            c.setBloc(b);
       }
        //b.getChambres().addAll(chambres);
        //blocRepository.save(b);
        chambreRepository.saveAll(chambres);
        return b;
    }
}
