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
public class Foyer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @OneToOne(mappedBy="foyer")
    private Universite universite;

    @OneToMany(mappedBy = "foyer",cascade=CascadeType.ALL)
    private Set<Bloc> blocs;


}
