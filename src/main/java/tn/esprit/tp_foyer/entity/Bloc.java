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
public class Bloc {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @OneToMany(cascade= CascadeType.ALL,mappedBy = "bloc")
    private Set<Chambre> chambres;

    @ManyToOne
    private Foyer foyer;

}
