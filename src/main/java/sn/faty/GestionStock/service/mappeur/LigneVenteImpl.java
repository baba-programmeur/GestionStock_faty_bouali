package sn.faty.GestionStock.service.mappeur;

import org.springframework.beans.BeanUtils;
import sn.faty.GestionStock.dto.LigneVenteDTO;
import sn.faty.GestionStock.model.LigneVente;

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
}
