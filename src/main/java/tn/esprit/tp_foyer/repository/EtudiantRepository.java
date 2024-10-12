package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp_foyer.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
