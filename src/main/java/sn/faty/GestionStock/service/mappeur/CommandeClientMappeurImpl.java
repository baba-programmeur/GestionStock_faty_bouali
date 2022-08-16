package sn.faty.GestionStock.service.mappeur;

import sn.faty.GestionStock.dto.CommandeClientDTO;
import sn.faty.GestionStock.model.CommandeClient;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientMappeurImpl implements  CommandeClientMappeur{

    @Override
    public List<CommandeClient> listEntity(List<CommandeClientDTO> listDto) {

        if(listDto==null)
            return null;
        List<CommandeClient> listCommandeClients=new ArrayList<>();

        for (CommandeClientDTO commandeClientDTO1:listDto) {

            listCommandeClients.add(this.toEntity(commandeClientDTO1));
        }
        return listCommandeClients ;
    }

    @Override
    public List<CommandeClientDTO> listDto(List<CommandeClient> listEntity) {
     if(listEntity==null)
     {
         return  null ;
     }
     List<CommandeClientDTO> listCommandeClientDto=new ArrayList<>();
       for (CommandeClient commandeClient:listEntity)

       {
           listCommandeClientDto.add(this.toDto(commandeClient));
       }
     return  listCommandeClientDto ;
    }

    @Override
    public CommandeClient toEntity(CommandeClientDTO commandeClientDTO) {

        if(commandeClientDTO==null)
        {
            return  null ;
        }
        CommandeClient commandeClient=new CommandeClient();

        commandeClient.setDateCommande(commandeClientDTO.getDateCommande());
        commandeClient.setCode(commandeClientDTO.getCode());
        commandeClient.setId(commandeClient.getId());
       // commandeClient.setClient(commandeClientDTO.getClient());

        return commandeClient;
    }

    @Override
    public CommandeClientDTO toDto(CommandeClient commandeClient) {

        if(commandeClient==null)
        {
            return  null ;
        }
        CommandeClientDTO commandeClientDTO=new CommandeClientDTO();

        commandeClientDTO.setDateCommande(commandeClient.getDateCommande());
        commandeClientDTO.setCode(commandeClient.getCode());
        commandeClientDTO.setId(commandeClient.getId());
        // commandeClient.setClient(commandeClientDTO.getClient());

        return commandeClientDTO;
    }


}
