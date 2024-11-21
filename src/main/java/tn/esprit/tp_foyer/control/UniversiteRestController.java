package tn.esprit.tp_foyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.service.IUniversiteService;

import java.util.List;

@Tag(name="Gestion des universités")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteService universiteService;

    //http://localhost:8089/foyer/universite/retrieve-all-universites
    @Operation(description="Récupérer tous les universités")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> retrieveAllUniversites() {
        return universiteService.findAllUniversites();
    }

    //http://localhost:8089/foyer/universite/retrieve-universite/8
    @Operation(description="Récupérer une université par son ID")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    //http://localhost:8089/foyer/universite/add-universite
    @Operation(description="Ajouter une université")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.saveUniversite(universite);
    }

    //http://localhost:8089/foyer/universite/delete-universite/7
    @Operation(description="Supprimer une université par son ID")
    @DeleteMapping("/delete-universite/{universite-id}")
    public void deleteUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }

    //http://localhost:8089/foyer/universite/modify-universite
    @Operation(description="Modifier une université")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }
}
