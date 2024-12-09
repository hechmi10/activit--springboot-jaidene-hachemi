package tn.esprit.tp_foyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.service.IBlocService;

import java.util.List;

@Tag(name="Gestion des blocs")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    //http://localhost:8089/foyer/bloc/retrieve-all-blocs
    @Operation(description = "Récupération de tous les blocs")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> retrieveAllBlocs() {
        return blocService.retrieveBlocs();
    }

    //http://localhost:8089/foyer/bloc/retrieve-bloc/1
    @Operation(description = "Récupération d'un bloc par son ID")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }

    //http://localhost:8089/foyer/bloc/add-bloc
    @Operation(description = "Ajout d'un bloc")
    @PostMapping("/save-bloc")
    public Bloc saveBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    //http://localhost:8089/foyer/bloc/delete-bloc/1
    @Operation(description = "Suppression d'un bloc par son ID")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    //http:localhost:8089/foyer/bloc/modify-bloc
    @Operation(description = "Modifier un bloc")
    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @Operation(description="Affecter des chambres à un bloc")
    @PostMapping("/affecter-chambres-a-bloc/")
    public Bloc affecterChambresABloc(@RequestParam List<Long> numChambres,@RequestParam Long idBloc){
        return blocService.affecterChambresABloc(numChambres,idBloc);
    }
}
