package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entity.Chambre;
import tn.esprit.tp_foyer.entity.TypeChambre;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Set<Chambre> findAllByNumeroChambreIn(List<Long> numerosChambre);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);

    @Query("Select c from Chambre c where c.bloc.idBloc=:idBloc and c.typeC=:typeC")
    List<Chambre> getChambresParBlocEtType(@Param("idBloc") long idBloc,@Param("typeC") TypeChambre typeC);

    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND c.typeC = :type " +
            "AND NOT EXISTS (SELECT r FROM Reservation r " +
            "                WHERE r.anneeUniversitaire = :currentYear)")
    public List<Chambre> findChambresNonReserveParNomUniversiteEtTypeC(
            @Param("nomUniversite") String nomUniversite,
            @Param("type") TypeChambre type,
            @Param("currentYear") Date currentYear);

}
