package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.Repository.ClientRepository;
import sn.faty.gestionstock.controlleur.Interfaces.ClientAPI;
import sn.faty.gestionstock.dto.ClientDTO;
import sn.faty.gestionstock.service.Interface.ClientService;

import java.util.List;

@RestController
@RequestMapping
public class ClientController implements ClientAPI {

    private ClientService clientService ;

    private  ClientRepository clientRepository ;
    @Autowired
    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        return  clientService.saveClient(clientDTO);
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @Override
    public void deleteById(Long id) {
        clientService.deleteById(id);
    }

    @Override
    public ClientDTO findById(Long id) {

        return clientService.findById(id);
    }

    @Override
    public ClientDTO findByNom(String nom) {
        return clientService.findByNom(nom);
    }
}
