package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entity.Universite;

import java.util.Optional;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    Optional<Universite> findByNomUniversite(String nom);

    @Query("Select u from Universite u join fetch u.foyer f join fetch f.blocs b where u.nomUniversite=:nomUniversite")
    Universite findByNomWithFoyerAndBlocs(@Param("nomUniversite") String nomUniversite);

}
