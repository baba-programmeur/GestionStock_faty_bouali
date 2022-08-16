package sn.faty.GestionStock.service.mappeur;
import org.springframework.stereotype.Service;
import sn.faty.GestionStock.dto.UtilisateurDTO;
import sn.faty.GestionStock.model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurMappeurImpl implements UtilisateurMappeur {

    @Override
    public List<UtilisateurDTO> listDto(List<Utilisateur> listUsers) {
        if(listUsers==null)
            return null;
        List<UtilisateurDTO> listUsersDto= new ArrayList<UtilisateurDTO>();

          for( Utilisateur utilisateur:listUsers)
              listUsersDto.add(this.toDto(utilisateur));
          return  listUsersDto ;
    }

    @Override
    public List<Utilisateur> listEntity(List<UtilisateurDTO> listUsersDto) {
        if(listUsersDto==null)
        return null;

        List<Utilisateur> listUsers= new ArrayList<Utilisateur>();

          for(UtilisateurDTO utilisateurDTO:listUsersDto)
          {
              listUsers.add(this.toEntity(utilisateurDTO));
          }

          return  listUsers ;
    }

    @Override
    public Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {

        if(utilisateurDTO==null)

           return null;

         Utilisateur utilisateur=new Utilisateur();
         utilisateur.setNom(utilisateurDTO.getNom());
         utilisateur.setEmail(utilisateurDTO.getEmail());
         utilisateur.setPrenom(utilisateurDTO.getPrenom());
         utilisateur.setDateNaissance(utilisateurDTO.getDateNaissance());
         utilisateur.setMotDePasse(utilisateurDTO.getMotDePasse());
         utilisateur.setPhoto(utilisateurDTO.getPhoto());
         utilisateur.setDateNaissance(utilisateurDTO.getDateNaissance());

         return utilisateur ;

    }

    @Override
    public UtilisateurDTO toDto(Utilisateur utilisateur) {

      if(utilisateur==null)
        return null;

      UtilisateurDTO utilisateurDTO=new UtilisateurDTO();
        utilisateurDTO.setId(utilisateur.getId());
        utilisateurDTO.setEmail(utilisateur.getEmail());
        utilisateurDTO.setNom(utilisateur.getNom());
        utilisateurDTO.setPhoto(utilisateur.getPhoto());
        utilisateurDTO.setMotDePasse(utilisateur.getMotDePasse());
        utilisateurDTO.setDateNaissance(utilisateur.getDateNaissance());
        utilisateurDTO.setPrenom(utilisateur.getPrenom());

        return  utilisateurDTO ;
    }
}
