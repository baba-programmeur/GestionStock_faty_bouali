package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.VenteApi;
import sn.faty.gestionstock.dto.VenteDTO;
import sn.faty.gestionstock.service.Interface.VenteService;

import java.util.List;
@RestController
@RequestMapping
public class VenteController implements VenteApi {

    private VenteService venteService ;
@Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @Override
    public ResponseEntity<VenteDTO> saveVente(VenteDTO venteDTO) {
        return ResponseEntity.ok().body(venteService.saveVente(venteDTO));
    }

    @Override
    public ResponseEntity<List<VenteDTO>> findAll() {
        return ResponseEntity.ok().body(venteService.findAll());
    }

    @Override
    public void deleteById(Long id) {
           venteService.deleteById(id);
    }

    @Override
    public ResponseEntity<VenteDTO> findById(Long id) {
        return ResponseEntity.ok().body(venteService.findById(id));
    }

    @Override
    public ResponseEntity<VenteDTO> findByCode(String code) {
        return ResponseEntity.ok().body(venteService.findByCode(code));
    }
}
