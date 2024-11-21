package tn.esprit.tp_foyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Etudiant;
import tn.esprit.tp_foyer.service.IEtudiantService;

import java.util.List;

@Tag(name="Gestion des étudiants")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;

    //http://localhost:8089/foyer/etudiant/retrieve-all-etudiants
    @Operation(description = "Récuperer tous les étudiants")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    //http://localhost:8089/foyer/etudiant/retrieve-etudiant/4
    @Operation(description = "Recupérer un étudiant par son ID")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiantById(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    //http://localhost:8089/foyer/etudiant/add-etudiant
    @Operation(description = "Ajouter un étudiant")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    //http://localhost:8089/foyer/etudiant/modify-etudiant
    @Operation(description = "Modifier un étudiant")
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    //http://localhost:8089/foyer/etudiant/delete-etudiant/1
    @Operation(description = "Supprimer un étudiant par son ID")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.removeEtudiant(etudiantId);
    }
}
