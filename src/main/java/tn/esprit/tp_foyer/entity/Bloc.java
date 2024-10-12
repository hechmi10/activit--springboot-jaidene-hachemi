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
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @OneToMany(mappedBy = "bloc",cascade= CascadeType.ALL)
    private Set<Chambre> chambres;

    @ManyToOne
    private Foyer foyer;

}
