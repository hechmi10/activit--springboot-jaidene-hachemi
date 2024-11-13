package tn.esprit.tp_foyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    //http:localhost:8089/foyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        return chambreService.retrieveAllChambres();
    }

    //http:localhost:8089/foyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre getChambreById(@PathVariable("chambre-id") Long id) {
        return chambreService.retrieveChambre(id);
    }

    //http:localhost:8089/foyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.createChambre(chambre);
    }

    //http://localhost:8089/foyer/chambre/remove-chambre/5
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long id) {
        chambreService.removeChambre(id);
    }

    //http:localhost:8089/foyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre chambre,Long id) {
        return chambreService.updateChambre(chambre,id);
    }
}
