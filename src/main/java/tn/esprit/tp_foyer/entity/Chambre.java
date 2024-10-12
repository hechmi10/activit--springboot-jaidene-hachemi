package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChambre;

    private int numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre TypeC;

    @OneToMany(cascade= CascadeType.ALL)
    private Set<Reservation> reservation;

    @ManyToOne
    private Bloc bloc;
}
