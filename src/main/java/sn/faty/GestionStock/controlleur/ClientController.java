package sn.faty.GestionStock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.GestionStock.Repository.ClientRepository;
import sn.faty.GestionStock.controlleur.Interfaces.ClientAPI;
import sn.faty.GestionStock.dto.ClientDTO;
import sn.faty.GestionStock.service.Interface.ClientService;

import java.util.List;

@RestController
@RequestMapping
public class ClientController implements ClientAPI {

    private ClientService clientService ;

    private ClientRepository clientRepository ;
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

    }

    @Override
    public ClientDTO findById(Long id) {
        return null;
    }

    @Override
    public ClientDTO findByNom(String nom) {
        return null;
    }
}
