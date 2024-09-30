package tn.esprit.tp_foyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;

}
