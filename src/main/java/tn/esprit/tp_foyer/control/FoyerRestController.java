package tn.esprit.tp_foyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.service.IFoyerService;

import java.util.List;

@Tag(name = "Gestion des foyers")
@RestController
@AllArgsConstructor
@RequestMapping("/foyerU")
public class FoyerRestController {
    IFoyerService foyerService;

    //http://localhost:8089/foyer/foyerU/retrieve-all-foyers
    @Operation(description = "Recupérer tous les foyers")
    @GetMapping("retrieve-all-foyers")
    public List<Foyer> retrieveAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    //http://localhost:8089/foyer/foyerU/retrieve-foyer/2
    @Operation(description = "Recupérer un foyer par son ID")
    @GetMapping("retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.retrieveFoyer(foyerId);
    }

    //http://localhost:8089/foyer/foyerU/add-foyer
    @Operation(description = "Ajouter un foyer")
    @PostMapping("add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.saveFoyer(foyer);
    }

    //http://localhost:8089/foyer/foyerU/delete-foyer/4
    @Operation(description = "Supprimer un foyer")
    @DeleteMapping("remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }

    //http://localhost:8089/foyer/foyerU/modify-foyer
    @Operation(description = "Modifier un foyer")
    @PutMapping("update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }
}
