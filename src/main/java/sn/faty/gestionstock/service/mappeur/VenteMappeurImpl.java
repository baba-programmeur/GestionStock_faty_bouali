package sn.faty.gestionstock.service.mappeur;

import org.springframework.beans.BeanUtils;
import sn.faty.gestionstock.dto.VenteDTO;
import sn.faty.gestionstock.model.Ventes;

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

        BeanUtils.copyProperties(venteDTO,vente);

//        vente.setCode(venteDTO.getCode());
//        vente.setCommentaire(venteDTO.getCommentaire());
//        vente.setDtVente(venteDTO.getDtVente());
//        vente.setId(vente.getId());
        return  vente ;
    }
    @Override
    public VenteDTO toDto(Ventes ventes) {

        if(ventes==null)
            return null;
        VenteDTO venteDTO= new VenteDTO( );

        BeanUtils.copyProperties(ventes,venteDTO);
//        venteDTO.setDtVente(ventes.getDtVente());
//        venteDTO.setCode(ventes.getCode());
//        venteDTO.setCommentaire(ventes.getCommentaire());
//        venteDTO.setId(venteDTO.getId());
        return  venteDTO ;
    }
}
