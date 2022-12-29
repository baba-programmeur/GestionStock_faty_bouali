package sn.faty.gestionstock.service.Interface;
import sn.faty.gestionstock.dto.ChangerMotDePasseDTO;
import sn.faty.gestionstock.dto.UtilisateurDTO;
import java.util.List;

public interface UtilisateurService {
    UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO);

    List<UtilisateurDTO> findAll();

    void deleteById(Long id);

    UtilisateurDTO  findById(Long id);

    UtilisateurDTO  findByNom(String code);

    UtilisateurDTO findByEmail(String username);
    UtilisateurDTO changerMotDePasse(ChangerMotDePasseDTO changerMotDePasseDTO);
}
