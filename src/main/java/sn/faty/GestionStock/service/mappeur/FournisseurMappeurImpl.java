package sn.faty.GestionStock.service.mappeur;


import sn.faty.GestionStock.dto.FournisseurDTO;
import sn.faty.GestionStock.model.Fournisseur;

import java.util.ArrayList;
import java.util.List;

public class FournisseurMappeurImpl  implements FournisseurMappeur {


    @Override
    public List<FournisseurDTO> listDto(List<Fournisseur> listEntity) {
       if(listEntity==null)
        return null;
       List<FournisseurDTO> listFournisseurs=new ArrayList<>();

        for (Fournisseur entity:listEntity) {
            listFournisseurs.add(this.toDto(entity));
        }
        return  listFournisseurs ;
    }

    @Override
    public List<Fournisseur> listEntity(List<FournisseurDTO> listFournisseurDto) {

        if(listFournisseurDto==null)

            return null;

        List<Fournisseur> listFournisseurs=new ArrayList<>();

        for (FournisseurDTO entity:listFournisseurDto) {

            listFournisseurs.add(this.toEntity(entity));
        }
        return  listFournisseurs ;
    }
    @Override
    public Fournisseur toEntity(FournisseurDTO fournisseurDTO) {
        if (fournisseurDTO==null)
            return null;
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setNom(fournisseurDTO.getNom());
        fournisseur.setPrenom(fournisseurDTO.getPrenom());
        fournisseur.setMail(fournisseurDTO.getMail());
        fournisseur.setPhoto(fournisseurDTO.getPhoto());
        fournisseur.setNumTel(fournisseurDTO.getNumTel());

        return  fournisseur ;
    }

    @Override
    public FournisseurDTO toDto(Fournisseur fournisseur) {

        if (fournisseur==null)
            return null;
        FournisseurDTO fournisseurDTO=new FournisseurDTO();
        fournisseurDTO.setNom(fournisseur.getNom());
        fournisseurDTO.setPrenom(fournisseur.getPrenom());
        fournisseurDTO.setMail(fournisseur.getMail());
        fournisseurDTO.setPhoto(fournisseur.getPhoto());
        fournisseurDTO.setNumTel(fournisseur.getNumTel());
        return  fournisseurDTO ;
    }

    @Override
    public Fournisseur toEntity(Fournisseur fournisseur) {
        return null;
    }


}
