//package sn.faty.gestionstock.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import sn.faty.gestionstock.service.auth.AuthService;
//
// @EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//  @Autowired
//     private AuthService authService ;
//  @Autowired
//    private  RequestFilter requestFilter ;
////  @Autowired
////    public SecurityConfiguration(AuthService authService,RequestFilter requestFilter) {
////
////      this.authService = authService;
////      this.requestFilter=requestFilter ;
////    }
////
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().antMatchers("/**/authentification",
//                        "/**/addEntreprise",
//                        "/v2/api-docs",
//                        "swagger-resources",
//                        "swagger-resources/**",
//                        "/configuration/ui",
//                        "/configuration/security",
//                        "/swagger-ui.html/**",
//                        "/webjars/**",
//                        "/v3/api-docs/**",
////                       "/gestionStock/V1/addUser",
//                        "/swagger-ui/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        //faire un filtre avant lexecution d'une requete.
//     http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
//    }
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//    @Bean
//   public PasswordEncoder passwordEncoder(){
//      return NoOpPasswordEncoder.getInstance();
//   }
////}
////
//
//}