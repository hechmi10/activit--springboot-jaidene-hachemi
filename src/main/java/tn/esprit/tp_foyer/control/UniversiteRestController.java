package tn.esprit.tp_foyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Universite;
import tn.esprit.tp_foyer.service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteService universiteService;

    //http://localhost:8089/foyer/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    public List<Universite> retrieveAllUniversites() {
        return universiteService.findAllUniversites();
    }

    //http://localhost:8089/foyer/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.findUniversiteById(universiteId);
    }

    //http://localhost:8089/foyer/universite/add-universite
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.saveUniversite(universite);
    }

    //http://localhost:8089/foyer/universite/delete-universite/7
    @DeleteMapping("/delete-universite/{universite-id}")
    public void deleteUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.deleteUniversite(universiteId);
    }

    //http://localhost:8089/foyer/universite/modify-universite
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite,Long id) {
        return universiteService.updateUniversite(universite,id);
    }
}
