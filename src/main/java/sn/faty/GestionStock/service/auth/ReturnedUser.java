//package sn.faty.gestionstock.service.auth;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.List;
//
//public class ReturnedUser extends ExtendUser {
//    public ReturnedUser(String email, String motDePasse, List<SimpleGrantedAuthority> roles) {
//        super(email,motDePasse,roles);
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
