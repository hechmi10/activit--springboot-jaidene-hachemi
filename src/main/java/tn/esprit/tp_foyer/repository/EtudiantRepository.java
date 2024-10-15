package tn.esprit.tp_foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.entity.Etudiant;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Override
    List<Etudiant> findAll();

    @Query("SELECT e.idEtudiant,e.nomEt,e.prenomEt,e.cin,e.ecole,e.dateNaissance FROM Etudiant e where e.dateNaissance BETWEEN :from and :to")
    List<Etudiant> retrieveByDateNaissanceBetween(@Param("from") Date from,@Param("to") Date to);
}
