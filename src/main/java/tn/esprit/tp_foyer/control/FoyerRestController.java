package tn.esprit.tp_foyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Foyer;
import tn.esprit.tp_foyer.service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyerU")
public class FoyerRestController {
    IFoyerService foyerService;

    //http://localhost:8089/foyer/foyerU/retrieve-all-foyers
    @GetMapping("retrieve-all-foyers")
    public List<Foyer> retrieveAllFoyers() {
        return foyerService.findAllFoyers();
    }

    //http://localhost:8089/foyer/foyerU/retrieve-foyer/2
    @GetMapping("retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.findFoyerById(foyerId);
    }

    //http://localhost:8089/foyer/foyerU/add-foyer
    @PostMapping("add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.saveFoyer(foyer);
    }

    //http://localhost:8089/foyer/foyerU/delete-foyer/4
    @DeleteMapping("delete-foyer/{foyer-id}")
    public void deleteFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.deleteFoyer(foyerId);
    }

    //http://localhost:8089/foyer/foyerU/modify-foyer
    @PutMapping("modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }
}
