package sn.faty.GestionStock.service.mappeur;

import sn.faty.GestionStock.dto.CategoryDTO;
import sn.faty.GestionStock.dto.LigneCommandeFournisseurDTO;
import sn.faty.GestionStock.model.Category;
import sn.faty.GestionStock.model.LigneCommandeFournisseur;

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
