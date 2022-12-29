//package sn.faty.gestionstock.service.auth;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import sn.faty.gestionstock.Repository.UtilisateurRepository;
//import sn.faty.gestionstock.dto.UtilisateurDTO;
//import sn.faty.gestionstock.model.Utilisateur;
//import sn.faty.gestionstock.service.Interface.UtilisateurService;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.*;
//
//@Service
//public class AuthService  implements UserDetailsService {
//
//@Autowired
//    private UtilisateurService utilisateurService ;
//@Autowired
//    private UtilisateurRepository utilisateurRepository ;
//@Autowired
//    public AuthService(UtilisateurService utilisateurService,UtilisateurRepository utilisateurRepository) {
//
//        this.utilisateurService=utilisateurService ;
//        this.utilisateurRepository=utilisateurRepository ;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<Utilisateur> utilisateur= utilisateurRepository.findUtilisateurByEmail(username);
//               if(utilisateur.isEmpty()){
//                   throw new EntityNotFoundException("ce nom dutilisateur nexiste pas");
//               }
////     UtilisateurDTO utilisateur= utilisateurService.findByEmail(username);
////
//     List<SimpleGrantedAuthority> authorities=new ArrayList<>();
//  utilisateur.get().getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())) );
//
//        return new ReturnedUser(utilisateur.get().getEmail(), utilisateur.get().getMotDePasse() ,authorities) ;   }
//}
