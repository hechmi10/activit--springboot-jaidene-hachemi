package tn.esprit.tp_foyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.service.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    //http://localhost:8089/foyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> retrieveAllBlocs() {
        return blocService.findAllBlocs();
    }

    //http://localhost:8089/foyer/bloc/retrieve-bloc/1
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.findBlocById(blocId);
    }

    //http://localhost:8089/foyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.saveBloc(bloc);
    }

    //http://localhost:8089/foyer/bloc/delete-bloc/1
    @DeleteMapping("/delete-bloc/{bloc-id}")
    public void deleteBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.deleteBloc(blocId);
    }

    //http:localhost:8089/foyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return blocService.saveBloc(bloc);
    }
}
