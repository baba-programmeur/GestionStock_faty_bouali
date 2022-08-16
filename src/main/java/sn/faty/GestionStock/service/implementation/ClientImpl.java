package sn.faty.GestionStock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.GestionStock.Repository.ClientRepository;
import sn.faty.GestionStock.Validators.ClientValidator;
import sn.faty.GestionStock.dto.ClientDTO;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.ErrorCodes;
import sn.faty.GestionStock.exception.InvalidException;
import sn.faty.GestionStock.service.Interface.ClientService;
import sn.faty.GestionStock.service.mappeur.ClientMappeur;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClientImpl implements ClientService {

    private ClientRepository clientRepository ;

    private ClientMappeur clientMappeur ;

    public ClientImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {

        List<String> errors= ClientValidator.validerClient(clientDTO);

        if(!errors.isEmpty())
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
