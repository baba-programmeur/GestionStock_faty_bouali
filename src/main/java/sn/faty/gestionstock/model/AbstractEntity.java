package sn.faty.gestionstock.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;


@Data
//@Builder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
//EntityListeners ecoute cette classe à chaque fois
// quelle est invoquee ,elle ajoute la date dans la base @CreatedDate
//ou update la date avec @LastModifiedDate
//il representent deux champs techniques
public class AbstractEntity implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private  Long id ;

   @CreatedDate
   //nullable=false -> lorsqu'on update la category la colonne create_date restera intacte
   @Column(name = "DateCreation",nullable = false,updatable = false)

    private Instant createdDate ;

   @LastModifiedDate
    @Column(name = "LastUpdateDate")
  //  @JsonIgnore
   //Champs techniques non exposes utilises pour faire des requetes de verification selon les dates
    private Instant lastUpdatedDate;

}
