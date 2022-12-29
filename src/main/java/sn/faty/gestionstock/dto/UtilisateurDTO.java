package sn.faty.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {

    private Long id ;
    private  String nom ;
    private  String prenom;

    private AdresseDTO adresse ;

    private Instant dateNaissance;

    private  String email;

    private  String motDePasse ;

    private  String photo ;
    private List<RolesDTO> roles ;
    private EntrepriseDTO entreprise;




}
