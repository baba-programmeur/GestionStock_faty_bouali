package sn.faty.gestionstock.service.mappeur;

import sn.faty.gestionstock.dto.LigneCommandeFournisseurDTO;
import sn.faty.gestionstock.model.LigneCommandeFournisseur;

public class LigneCommandeFournisseurImpl {

    public static LigneCommandeFournisseurDTO  toDto(LigneCommandeFournisseur ligneCommandeFournisseur)
    {
        if(ligneCommandeFournisseur==null)
        {
            return null ;
        }
        return  LigneCommandeFournisseurDTO.builder()
                .id(ligneCommandeFournisseur.getId())
                .build();
    }
    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDTO ligneCommandeFournisseurDTO)
    {
        if (ligneCommandeFournisseurDTO==null)
        {
            return  null ;
        }

       LigneCommandeFournisseur  ligneCommandeFournisseur=new LigneCommandeFournisseur();

        ligneCommandeFournisseur.setId(ligneCommandeFournisseur.getId());

        return  ligneCommandeFournisseur ;
    }


}
