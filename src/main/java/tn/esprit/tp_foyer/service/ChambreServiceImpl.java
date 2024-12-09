package tn.esprit.tp_foyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.entity.TypeChambre;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.repository.BlocRepository;
import tn.esprit.tp_foyer.repository.ChambreRepository;
import tn.esprit.tp_foyer.repository.UniversiteRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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

    @Scheduled(cron="0 */5 * * * *")
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres=chambreRepository.findAll();
        List<Chambre> chambresSimples=new ArrayList<>();
        List<Chambre> chambresDoubles=new ArrayList<>();
        List<Chambre> chambresTriples=new ArrayList<>();
        log.info("Nombre total des chambres: {}",chambres.size());
        for(Chambre c:chambres){
            if(c.getTypeC()==TypeChambre.SIMPLE){
                chambresSimples.add(c);
                Double p1=(chambresSimples.size()/chambres.size())*100.0;
                log.info("Le pourcentage pour les chambres de type SIMPLE est: {}",p1);
            }else if(c.getTypeC()==TypeChambre.DOUBLE){
                chambresDoubles.add(c);
                Double p2=(chambresDoubles.size()/chambres.size())*100.0;
                log.info("Le pourcentage pour les chambres de type DOUBLE est: {}",p2);
            }else{
                chambresTriples.add(c);
                Double p3=(chambresTriples.size()/chambres.size())*100.0;
                log.info("Le pourcentage pour les chambres de type TRIPLE est: {}",p3);
            }
        }
    }

    @Scheduled(cron = "0 */5 * * * *")
    void nbPlacesDisponibleParChambreAnneeEnCours(){
        List<Chambre> chambres=chambreRepository.findAll();
        for (Chambre chambre : chambres) {
            int availablePlaces = chambre.getAvailablePlaces();
            String logMessage;
            if (availablePlaces == 0) {
                logMessage = "La chambre " + chambre.getTypeC() + " " + chambre.getNumeroChambre() + " est complète";
            } else {
                logMessage = "Le nombre de place disponible pour la chambre " + chambre.getTypeC() + " " + chambre.getNumeroChambre() + " est " + availablePlaces;
            }
            log.info(logMessage);
        }

    }

    public String checkRoomAvailability(String roomName, int roomId, int availablePlaces) {
        if (availablePlaces == 0) {
            return "La chambre " + roomName + " " + roomId + " est complète";
        } else {
            return "Le nombre de place disponible pour la chambre " + roomName + " " + roomId + " est " + availablePlaces;
        }
    }


}
