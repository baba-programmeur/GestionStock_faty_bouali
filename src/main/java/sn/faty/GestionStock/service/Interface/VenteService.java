package sn.faty.gestionstock.service.Interface;

import sn.faty.gestionstock.dto.VenteDTO;

import java.util.List;

public interface VenteService {

    VenteDTO saveVente(VenteDTO venteDTO);

    List<VenteDTO> findAll();

    void deleteById(Long id);

    VenteDTO  findById(Long id);

   VenteDTO findByCode(String code);



}
