package sn.faty.gestionstock.service.Interface;

import sn.faty.gestionstock.dto.CommandeFournisseurDTO;

import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDTO savecommmandeFournisseur( CommandeFournisseurDTO  commandeFournisseurDTO);

    List<CommandeFournisseurDTO> findAll();

    void deleteById(Long id);

 CommandeFournisseurDTO findById(Long id);

    CommandeFournisseurDTO  findByCode(String code);

   // CommandeFournisseurDTO findByNom(String nom);
}
