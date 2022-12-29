package sn.faty.gestionstock.service.Interface;
import sn.faty.gestionstock.dto.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDTO saveEntreprise(EntrepriseDTO entrepriseDTO);

    List<EntrepriseDTO> findAll();

    void deleteById(Long id);

    EntrepriseDTO findById(Long id);

    EntrepriseDTO findByNom(String code);
}
