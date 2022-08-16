package sn.faty.GestionStock.service.Interface;
import sn.faty.GestionStock.dto.UtilisateurDTO;
import java.util.List;

public interface UtilisateurService {

    UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO);

    List<UtilisateurDTO> findAll();

    void deleteById(Long id);

    UtilisateurDTO  findById(Long id);

    UtilisateurDTO  findByNom(String code);

}
