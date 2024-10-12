package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.entity.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
