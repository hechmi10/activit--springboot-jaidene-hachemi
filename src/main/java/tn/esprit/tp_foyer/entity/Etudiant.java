package tn.esprit.tp_foyer.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    private Date dateNaissance;

    @ManyToMany(mappedBy="etudiants",cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
