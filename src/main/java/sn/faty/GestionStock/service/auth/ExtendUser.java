//package sn.faty.gestionstock.service.auth;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collection;
//import java.util.List;
//
//public class ExtendUser extends User {
//    @Getter
//    @Setter
//    private Integer idEntreprise;
//    public ExtendUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//    }
//    public ExtendUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//    }
//
//    public ExtendUser(String email, String motDePasse, Long id, List<SimpleGrantedAuthority> authorities) {
//        super(email,motDePasse,authorities);
//    }
//}
