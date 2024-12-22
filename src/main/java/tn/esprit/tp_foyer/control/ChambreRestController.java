package tn.esprit.tp_foyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.entity.Reservation;
import tn.esprit.tp_foyer.entity.TypeChambre;
import tn.esprit.tp_foyer.service.IChambreService;

import java.util.List;

@Tag(name = "Gestion des chambres")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    //http:localhost:8089/foyer/chambre/retrieve-all-chambres
    @Operation(description = "Récuperer tous les chambres")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> retrieveAllChambres() {
        return chambreService.retrieveAllChambres();
    }

    //http:localhost:8089/foyer/chambre/retrieve-chambre/8
    @Operation(description = "Récuperer une chambre par son ID")
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long id) {
        return chambreService.retrieveChambre(id);
    }

    //http:localhost:8089/foyer/chambre/add-chambre
    @Operation(description = "Ajout d'une chambre")
    @PostMapping("/create-chambre")
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }



    //http:localhost:8089/foyer/chambre/modify-chambre
    @Operation(description="Modification d'une chambre")
    @PutMapping("/update-chambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @Operation(description="Récuperer des chambres par son bloc et type")
    @GetMapping("getChambresParBlocEtType/bloc/{idBloc}/type/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable("idBloc") long idBloc, @PathVariable("typeC") TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc,typeC);
    }

    @Operation(description="Recupérer des chambres par leur nom de l'université")
    @GetMapping("/getChambresParNomUniversitaire/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversitaire(@PathVariable("nomUniversite") String nomUniversite){
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }

    @Operation(description = "Récuperer des chambres non resérvés par leur nom d'université et leur type de chambre")
    @GetMapping("/getChambresNonReserveesParNomUniversiteEtTypeChambre/{nomUniversite}/{typeC}")
    public List<Chambre> getChambresNonReserveesParNomUniversiteEtTypeChambre(@PathVariable("nomUniversite") String nomUniversite,@PathVariable("typeC") TypeChambre typeC){
        return chambreService.getChambreNonReservesParNomUniversiteEtTypeChambre(nomUniversite,typeC);
    }

    @DeleteMapping("/delete-chambre/{idChambre}")
    public void deleteChambre(@PathVariable("idChambre") Long idChambre) {
        chambreService.deleteChambre(idChambre);
    }
}
