package sn.faty.GestionStock.service.Interface;
import sn.faty.GestionStock.dto.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDTO saveEntreprise(EntrepriseDTO entrepriseDTO);

    List<EntrepriseDTO> findAll();

    void deleteById(Long id);

    EntrepriseDTO findById(Long id);

    EntrepriseDTO findByNom(String code);
}
