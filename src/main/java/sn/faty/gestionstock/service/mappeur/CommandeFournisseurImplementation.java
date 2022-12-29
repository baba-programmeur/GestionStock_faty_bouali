package sn.faty.gestionstock.service.mappeur;

import sn.faty.gestionstock.dto.CommandeFournisseurDTO;
import sn.faty.gestionstock.model.CommandeFournisseur;


public class CommandeFournisseurImplementation {

    public static CommandeFournisseurDTO  toDto(CommandeFournisseur commandeFournisseur)
    {
        if(commandeFournisseur==null)
        {
            return null ;
        }
        return  CommandeFournisseurDTO.builder()
                .id(commandeFournisseur.getId())
                .dateCommandeFournisseur(commandeFournisseur.getDateCommandeFournisseur())
                .build();
    }
    public static CommandeFournisseur toEntity(CommandeFournisseurDTO commandeFournisseurDTO)
    {
        if (commandeFournisseurDTO==null)
        {
            return  null ;
        }

        CommandeFournisseur commandeFournisseur=new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDTO.getId());
        commandeFournisseur.setCodeFournisseur(commandeFournisseurDTO.getCodeFournisseur());
        commandeFournisseur.setDateCommandeFournisseur(commandeFournisseurDTO.getDateCommandeFournisseur());

        return  commandeFournisseur ;
    }

}
