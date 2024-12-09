package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;

import java.util.List;
import java.util.Set;

@Slf4j
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
        assert b != null;
        b.getChambres().addAll(chambres);
        blocRepository.save(b);
        chambreRepository.saveAll(chambres);
        return b;
    }

    @Scheduled(cron="0 * * * * *")
    public void listeChambresParBloc() {
        List<Bloc> blocs=blocRepository.findAll();
        List<Chambre> chambres=chambreRepository.findAll();
        for(Bloc b:blocs){
            log.info("******************************");
            log.info("Bloc => {} ayant une capacité {}", b.getNomBloc(),b.getCapaciteBloc());
            if(b.getChambres().isEmpty()){
                log.info("Pas de chambre disponible dans ce bloc");
            }else {
                for (Chambre c : b.getChambres()) {
                    log.info("La liste des chambres pour ce bloc:");
                    if(b.getChambres().contains(c)){
                        log.info("NumChambre: {} type : {}", c.getNumeroChambre(), c.getTypeC());
                    }
                }
            }
        }
    }

}
