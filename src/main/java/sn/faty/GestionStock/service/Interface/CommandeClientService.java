package sn.faty.GestionStock.service.Interface;

import sn.faty.GestionStock.dto.CommandeClientDTO;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDTO savecommmandeclient(CommandeClientDTO commandeClientDTO);

    List<CommandeClientDTO> findAll();

    void deleteById(Long id);

   CommandeClientDTO findById(Long id);

    CommandeClientDTO findByCode(String code);
}
