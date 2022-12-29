package sn.faty.gestionstock.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import sn.faty.gestionstock.controlleur.Interfaces.CommandeFournisseurAPI;

import sn.faty.gestionstock.dto.CommandeFournisseurDTO;
import sn.faty.gestionstock.service.Interface.CommandeFournisseurService;


import java.util.List;
@RestController
public class CommandeFournisseurControlleur implements CommandeFournisseurAPI {

private CommandeFournisseurService commandeFournisseurService;

@Autowired

public  CommandeFournisseurControlleur(CommandeFournisseurService commandeFournisseurService) {

    this.commandeFournisseurService = commandeFournisseurService;
}
    @Override
    public ResponseEntity<CommandeFournisseurDTO> saveFournisseurCommand(CommandeFournisseurDTO commandeFournisseurDTO) {
        return   ResponseEntity.ok(commandeFournisseurService.savecommmandeFournisseur(commandeFournisseurDTO)) ;
    }

    @Override
    public ResponseEntity<List<CommandeFournisseurDTO>> findAll() {
        return ResponseEntity.ok(commandeFournisseurService.findAll());
    }

    @Override
    public void deleteById(Long id) {
       commandeFournisseurService.deleteById(id);
    }

    @Override
    public ResponseEntity<CommandeFournisseurDTO> findById(Long id) {
        return ResponseEntity.ok(commandeFournisseurService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDTO> findByNom(String nom) {
        return ResponseEntity.ok(commandeFournisseurService.findByCode(nom));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDTO> findByCode(String code) {
        return ResponseEntity.ok(commandeFournisseurService.findByCode(code));
    }
}
