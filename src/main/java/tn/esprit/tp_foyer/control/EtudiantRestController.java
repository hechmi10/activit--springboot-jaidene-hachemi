package tn.esprit.tp_foyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Etudiant;
import tn.esprit.tp_foyer.service.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;

    //http://localhost:8089/foyer/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    //http://localhost:8089/foyer/etudiant/retrieve-etudiant/4
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiantById(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiantById(etudiantId);
    }

    //http://localhost:8089/foyer/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    //http://localhost:8089/foyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant,Long id) {
        return etudiantService.updateEtudiant(etudiant,id);
    }

    //http://localhost:8089/foyer/etudiant/delete-etudiant/1
    @DeleteMapping("/delete-etudiant/{etudiant-id}")
    public void deleteEtudiantById(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.deleteEtudiantById(etudiantId);
    }
}
