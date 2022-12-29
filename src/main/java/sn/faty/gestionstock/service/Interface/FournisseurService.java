package sn.faty.gestionstock.service.Interface;

import sn.faty.gestionstock.dto.FournisseurDTO;

import java.util.List;

public interface  FournisseurService {

   FournisseurDTO saveFournisseur(FournisseurDTO fournisseurDTO);

    List<FournisseurDTO> findAll();

    void deleteById(Long id);

  FournisseurDTO  findById(Long id);

    FournisseurDTO findByNom(String code);

}
