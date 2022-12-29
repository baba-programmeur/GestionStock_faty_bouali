package sn.faty.gestionstock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.ClientRepository;
import sn.faty.gestionstock.Repository.CommandeClientRepository;
import sn.faty.gestionstock.Validators.ClientValidator;
import sn.faty.gestionstock.dto.ClientDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.CommandeClient;
import sn.faty.gestionstock.service.Interface.ClientService;
import sn.faty.gestionstock.service.mappeur.ClientMappeur;
import sn.faty.gestionstock.service.mappeur.ClientMappeurImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ClientImpl implements ClientService {

    private ClientRepository clientRepository ;
    private ClientMappeur clientMappeur =new ClientMappeurImpl();
    private CommandeClientRepository commandeClientRepository ;
@Autowired
    public ClientImpl(ClientRepository clientRepository,CommandeClientRepository commandeClientRepository) {
        this.clientRepository = clientRepository;
        this.commandeClientRepository=commandeClientRepository ;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {

        List<String> errors= ClientValidator.validerClient(clientDTO);

        if(! errors.isEmpty())
        {
            log.debug("Client is not valid {} :",clientDTO);

            throw new InvalidException("Client is not valid", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }

        return  clientMappeur.toDto(clientRepository.save(clientMappeur.toEntity(clientDTO)));

    }

    @Override
    public List<ClientDTO> findAll() {
        return  clientRepository.findAll().stream()
                .map(clientMappeur::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id==null)
        {
            log.debug("id is null {}");
        }
List<CommandeClient> commandeClient= commandeClientRepository.findCommandeClientByClientId(id);

           if(!commandeClient.isEmpty())
           {
               throw  new InvalidOperationException("Impossible de supprimer un client engage dans une commande",ErrorCodes.COMMANDE_QUI_A_DEJA_COMMANDE);
           }
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDTO findById(Long id) {
        if(id==null)
        {
            log.debug("Id is null {}",id);
            return null;
        }
        return clientMappeur.toDto(clientRepository.findById(id)
                .orElseThrow(() ->
                        new EntittyNotFoundException("Article with id :"+ id + " is " +
                                "not in the database",ErrorCodes.ARTICLE_NOT_FOUND)));
    }
    @Override
    public ClientDTO findByNom(String nom) {
        if(!StringUtils.hasText(nom))
        {
            log.debug("Veuiller donner un nom à rechercher");
            throw  new InvalidException("Veuiller donner un nom à rechercher");
        }
        return clientMappeur.toDto(clientRepository.findClientByNom(nom))  ;
    }
}
