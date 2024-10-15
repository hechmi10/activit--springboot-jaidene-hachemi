package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    private int numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre TypeC;

    @OneToMany(cascade= CascadeType.ALL)
    private Set<Reservation> reservation;

    @ManyToOne
    private Bloc bloc;
}
