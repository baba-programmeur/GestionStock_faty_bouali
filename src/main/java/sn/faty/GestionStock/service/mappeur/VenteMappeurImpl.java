package sn.faty.GestionStock.service.mappeur;

import sn.faty.GestionStock.dto.VenteDTO;
import sn.faty.GestionStock.model.Ventes;

import java.util.ArrayList;
import java.util.List;

public class VenteMappeurImpl  implements VenteMappeur {
    @Override
    public   List<VenteDTO> listDto(List<Ventes> listEntity) {

        if(listEntity==null)
        return null;

        List<VenteDTO> listVenteDTO=new ArrayList<>();

          for(Ventes vente:listEntity )

              listVenteDTO.add(this.toDto(vente));

          return  listVenteDTO ;

    }

    @Override
    public List<Ventes> listEntity(List<VenteDTO> listDto) {
        if(listDto==null)
            return null;

        List<Ventes> listVentes=new ArrayList<>();

        for(VenteDTO ventedto:listDto )

            listVentes.add(this.toEntity(ventedto));

        return  listVentes ;
    }

    @Override
    public Ventes toEntity(VenteDTO venteDTO) {

        if(venteDTO==null)
        return null;
        Ventes vente= new Ventes( );

        vente.setDtVente(venteDTO.getDtVente());
        vente.setCode(venteDTO.getCode());
        vente.setCommentaire(venteDTO.getCommentaire());
        vente.setId(vente.getId());
        return  vente ;
    }

    @Override
    public VenteDTO toDto(Ventes ventes) {

        if(ventes==null)
            return null;
        VenteDTO venteDTO= new VenteDTO( );
        venteDTO.setDtVente(ventes.getDtVente());
        venteDTO.setCode(ventes.getCode());
        venteDTO.setCommentaire(ventes.getCommentaire());
        venteDTO.setId(venteDTO.getId());
        return  venteDTO ;
    }
}
