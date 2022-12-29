package sn.faty.gestionstock.service.Interface;
import sn.faty.gestionstock.dto.ClientDTO;
import java.util.List;


public interface ClientService {

    ClientDTO saveClient(ClientDTO clientDTO);

    List<ClientDTO> findAll();

    void deleteById(Long id);

    ClientDTO findById(Long id);

    ClientDTO findByNom(String nom);
}
