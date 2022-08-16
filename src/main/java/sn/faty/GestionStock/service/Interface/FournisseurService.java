package sn.faty.GestionStock.service.Interface;

import org.springframework.stereotype.Service;
import sn.faty.GestionStock.dto.ArticleDTO;
import sn.faty.GestionStock.dto.FournisseurDTO;

import java.util.List;

public interface  FournisseurService {

   FournisseurDTO saveFournisseur(FournisseurDTO fournisseurDTO);

    List<FournisseurDTO> findAll();

    void deleteById(Long id);

  FournisseurDTO  findById(Long id);

    FournisseurDTO findByNom(String code);

}
