package sn.faty.GestionStock.service.Interface;

import sn.faty.GestionStock.dto.CommandeClientDTO;
import sn.faty.GestionStock.dto.CommandeFournisseurDTO;

import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDTO savecommmandeFournisseur( CommandeFournisseurDTO  commandeFournisseurDTO);

    List<CommandeFournisseurDTO> findAll();

    void deleteById(Long id);

 CommandeFournisseurDTO findById(Long id);

    CommandeFournisseurDTO  findByCode(String code);
}
