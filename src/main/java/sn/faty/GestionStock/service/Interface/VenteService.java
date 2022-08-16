package sn.faty.GestionStock.service.Interface;

import sn.faty.GestionStock.dto.UtilisateurDTO;
import sn.faty.GestionStock.dto.VenteDTO;

import java.util.List;

public interface VenteService {

    VenteDTO saveUtilisateur(VenteDTO venteDTO);

    List<VenteDTO> findAll();

    void deleteById(Long id);

    VenteDTO  findById(Long id);

   VenteDTO findByNom(String code);



}
