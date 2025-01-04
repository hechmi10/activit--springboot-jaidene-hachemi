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
public class Reservation implements Serializable {

    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy="reservations")
    private Set<Etudiant> etudiants;

}
