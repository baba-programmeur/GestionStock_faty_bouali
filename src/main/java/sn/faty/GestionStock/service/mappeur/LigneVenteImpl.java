package sn.faty.gestionstock.service.mappeur;

import org.springframework.beans.BeanUtils;
import sn.faty.gestionstock.dto.FournisseurDTO;
import sn.faty.gestionstock.dto.LigneVenteDTO;
import sn.faty.gestionstock.model.Fournisseur;
import sn.faty.gestionstock.model.LigneVente;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteImpl {


    public static LigneVenteDTO toDto(LigneVente ligneVente) {
        if(ligneVente==null )
            return  null ;
        return LigneVenteDTO.builder()
                .id(ligneVente.getId())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .quantite(ligneVente.getQuantite())
                .build();
    }
    public static LigneVente toEntity(LigneVenteDTO ligneVenteDTO)
    {
        if(ligneVenteDTO==null)

            return  null ;

        LigneVente  ligneVente=new LigneVente();

        BeanUtils.copyProperties(ligneVenteDTO,ligneVente);

        return  ligneVente ;

    }

    public List<LigneVenteDTO> listDto(List<LigneVente> listEntity) {
        if(listEntity==null)
            return null;
        List<LigneVenteDTO> listFournisseurs=new ArrayList<>();

        for (LigneVente entity:listEntity) {

            listFournisseurs.add(this.toDto(entity));
        }
        return  listFournisseurs ;
    }

    public  static List<LigneVente> listEntity(List<LigneVenteDTO> listLigneVenteDto) {

        if(listLigneVenteDto==null)

            return null;

        List<LigneVente> listLigneVente=new ArrayList<>();

        for (LigneVenteDTO entity:listLigneVenteDto) {

            listLigneVente.add(toEntity(entity));
        }
        return  listLigneVente ;
    }
}
