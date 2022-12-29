//package sn.faty.gestionstock.controlleur;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sn.faty.gestionstock.dto.auth.authRequest;
//import sn.faty.gestionstock.dto.auth.authResponse;
//import sn.faty.gestionstock.service.JwtUtil;
//import sn.faty.gestionstock.service.auth.AuthService;
//import sn.faty.gestionstock.service.auth.ExtendUser;
//import sn.faty.gestionstock.service.auth.ReturnedUser;
//
//import static sn.faty.gestionstock.constants.Constants.END_POINT;
//
//@RestController
//@RequestMapping
//public class AuthenticationController {
//
//     @Autowired
//     private AuthenticationManager authenticationManager ;
//     @Autowired
//      private AuthService authService;
//      @Autowired
//      private JwtUtil jwtUtil ;
//
//    @Autowired
//    public AuthenticationController(AuthenticationManager authenticationManager,AuthService authService,JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.authService=authService ;
//        this.jwtUtil=jwtUtil ;
//    }
//    @PostMapping(value = END_POINT+"/authentification")
//    public ResponseEntity<authResponse> authentification(@RequestBody authRequest authRequest){
//        //cette classe bloque lacces à notre endPoint donc il fallait le commenter
//        //pour generer un token
//
// authenticationManager.authenticate(
//    new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getMdp()));
//
//      final UserDetails userDetailsService= authService.loadUserByUsername(authRequest.getLogin());
//
//     final String jwtUtil= this.jwtUtil.generateToken((ReturnedUser)userDetailsService);
//
//        return ResponseEntity.ok(authResponse.builder().token(jwtUtil).build());
//    }
//}