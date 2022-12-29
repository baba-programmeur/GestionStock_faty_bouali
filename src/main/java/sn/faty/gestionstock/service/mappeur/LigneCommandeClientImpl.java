package sn.faty.gestionstock.service.mappeur;

import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.model.LigneCommandeClient;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientImpl implements LigneCommandeClientMappeur {

    @Override
    public List<LigneCommandeClientDTO> listDto(List<LigneCommandeClient> listEntity) {

        if(listEntity==null)
            return null;
        List<LigneCommandeClientDTO> listCommandeClientDto=new ArrayList<>();

        for (LigneCommandeClient entity:listEntity) {
            listCommandeClientDto.add(this.toDto(entity));
        }
        return  listCommandeClientDto;
    }

    @Override
    public List<LigneCommandeClient> listEntity(List<LigneCommandeClientDTO> listDto) {
        if(listDto==null)
            return null;
        List<LigneCommandeClient> listCommandeClient=new ArrayList<>();

        for (LigneCommandeClientDTO entity:listDto) {
            listCommandeClient.add(this.toEntity(entity));
        }
        return  listCommandeClient;
    }
    @Override
    public LigneCommandeClient toEntity(LigneCommandeClientDTO ligneCommandeClientDTO) {

        if(ligneCommandeClientDTO==null)

           return null;

         LigneCommandeClient ligneCommandeClient=new LigneCommandeClient();

         ligneCommandeClient.setQuantite(ligneCommandeClientDTO.getQuantite());

         ligneCommandeClient.setPrixUnitaire(ligneCommandeClient.getPrixUnitaire());

        return  ligneCommandeClient ;
    }

    @Override
    public   LigneCommandeClientDTO toDto(LigneCommandeClient ligneCommandeClient) {

        if(ligneCommandeClient==null)

            return null;
        LigneCommandeClientDTO ligneCommandeClientDTO=new LigneCommandeClientDTO();

        ligneCommandeClientDTO.setQuantite(ligneCommandeClient.getQuantite());

        ligneCommandeClientDTO.setPrixUnitaire(ligneCommandeClient.getPrixUnitaire());
        //Article ,Commande client
        return  ligneCommandeClientDTO ;
    }
}
