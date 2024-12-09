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

    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @OneToMany(cascade= CascadeType.ALL)
    private Set<Reservation> reservation;

    @ManyToOne
    private Bloc bloc;

    // Add this method to calculate available places
    public int getAvailablePlaces() {
        int totalPlaces = 2; // or any number you want as the total capacity of the room
        int reservedPlaces = reservation.size();
        return totalPlaces - reservedPlaces;  // Return available places
    }
}
