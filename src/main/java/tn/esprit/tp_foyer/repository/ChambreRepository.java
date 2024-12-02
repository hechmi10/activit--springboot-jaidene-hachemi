package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entity.Bloc;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.entity.TypeChambre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Set<Chambre> findAllByNumeroChambre(List<Long> numerosChambre);

    List<Chambre> findAllByBlocIdBlocAndTypeChambre(long idBloc, TypeChambre typeC);

    @Query("Select c from Chambre c where c.bloc.idBloc=:idBloc and c.TypeC=:typeC")
    List<Chambre> getChambresParBlocEtType(@Param("idBloc") long idBloc,@Param("typeC") TypeChambre typeC);
}
