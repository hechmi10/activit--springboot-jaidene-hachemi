package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entity.Chambre;

import java.util.List;
import java.util.Set;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Set<Chambre> findAllByNumeroChambre(List<Long> numerosChambre);
}
