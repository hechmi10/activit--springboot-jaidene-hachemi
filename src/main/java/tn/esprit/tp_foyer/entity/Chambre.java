package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;

@Entity
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChambre;

    private int numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre TypeC;
}
