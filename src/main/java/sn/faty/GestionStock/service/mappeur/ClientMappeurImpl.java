package sn.faty.GestionStock.service.mappeur;

import sn.faty.GestionStock.dto.ClientDTO;
import sn.faty.GestionStock.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientMappeurImpl implements ClientMappeur {
    /**
     * @param clientDTO
     * @return a client which come from clientDto transformation
     */
    @Override
    public  Client toEntity(ClientDTO clientDTO) {

        if(clientDTO==null)

        return null;

        Client client =new Client();

        client.setNom(clientDTO.getNom());
        client.setPrenom(clientDTO.getPrenom());
        client.setNumTel(clientDTO.getNumTel());
        client.setMail(clientDTO.getMail());
        client.setPhoto(clientDTO.getPhoto());
        return  client ;
    }

    /**
     * @param client
     * @return
     */
    @Override
    public ClientDTO toDto(Client client) {

        if(client==null)

            return null;
        ClientDTO clientDTO =new ClientDTO();

        clientDTO.setNom(client.getNom());
        clientDTO.setPrenom(client.getPrenom());
        clientDTO.setNumTel(client.getNumTel());
        clientDTO.setMail(client.getMail());
        clientDTO.setPhoto(client.getPhoto());
        client.setCommandeClients(client.getCommandeClients());
        client.setAdresse(client.getAdresse());
        return  clientDTO;
    }

    /**
     * @param listEntity
     * @return
     */
    @Override
    public List<ClientDTO> listDto(List<Client> listEntity) {
        if(listEntity==null)
        return null;
        ArrayList<ClientDTO> listClients=new ArrayList<ClientDTO>();
        for (Client client:listEntity)
        {
            listClients.add(this.toDto(client));

        }
        return  listClients ;
    }
    /**
     * @param listDto
     * @return
     */
    @Override
    public List<Client> listEntity(List<ClientDTO> listDto) {

       if(listDto==null)

        return null;

       List<Client> listClientDTO=new ArrayList<Client>();

       for(ClientDTO clientDto:listDto)

           listClientDTO.add(this.toEntity(clientDto));

           return listClientDTO ;
    }
}
