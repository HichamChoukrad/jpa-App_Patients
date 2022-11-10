package org.sid.jpaapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;
@Entity

@Data /*Lombok il va ajouter getters et setters*/ @NoArgsConstructor /*ajouter un constructeur sans paramètre */ @AllArgsConstructor /*un constructeur avec paramètre */
public class Patient {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name="NOM", length  =50)
    private String nom;
    @Temporal(TemporalType.DATE)
    /*Spécifier les types date et garder seulement Année mois jour,
    @Temporal(TemporalType.TIME) garder hour minute seconde
    @Temporal(TemporalType.TIMESTAMP) garder les deux*/
    private Date dateNaissance;
    private boolean malade;
    private int score;


}
