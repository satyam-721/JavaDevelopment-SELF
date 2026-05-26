package com.satyam.SpringSecurity.config;

import com.satyam.SpringSecurity.service.MyUserdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SpringConfig {


    /**
 |--------------------------------------------------------------------------
 | Spring Security Configuration
 |--------------------------------------------------------------------------
 |
 | This class customizes Spring Security's default behavior.
 |
 | Important Notes:
 |
 | 1. Declaring a SecurityFilterChain bean overrides Spring Security's
 |    default configuration.
 |
 | 2. Some defaults still remain unless explicitly changed
 |    (example: CSRF protection).
 |
 | 3. This configuration:
 |      - Disables CSRF
 |      - Secures every endpoint
 |      - Enables Form Login
 |      - Enables HTTP Basic Authentication
 |      - Makes the application stateless
 |
 **/


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

            /**
             | CSRF Configuration
             |
             | CSRF is mainly needed for browser-based session authentication.
             | Since we are using stateless APIs, disabling it is common.
             |
             */
            .csrf(csrf -> csrf.disable())

            /**
             | Authorization Rules
             |
             | Every incoming request must be authenticated.
             |
             */
            .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/register")
                                    .permitAll()
                            .anyRequest().authenticated()
            )


            /**
             |--------------------------------------------------------------------------
             | Authentication Methods
             |--------------------------------------------------------------------------
             */

            // Default Spring Security login form
            .formLogin(Customizer.withDefaults())

            // HTTP Basic Authentication
            .httpBasic(Customizer.withDefaults());

            /**
             | Session Management
             |
             | STATELESS means:
             | - Spring Security will NOT create sessions
             | - Every request must carry authentication credentials
             | - Commonly used in REST APIs with JWT
             |
             */
//            .sessionManagement(session ->
//                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            );

        return http.build();
    }



//    @Bean

    /**
 |
 |  This method provides User Data
 |
 | Important Notes:
 |
 | 1. InMemoryUserDetailsManager stores users in config, no database required
 |
 | 2. user defined in application properties will be override
 |
 | 3. This is used in
        - custom users
        - multiple users
        - roles
        - different credentials
 |
 */

//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("satyam721")
//                .password("1234")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("sagar")
//                .password("12345")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//
//    }


    @Autowired
    UserDetailsService userdetailsService;   //MyUserdetailsService.java

    @Bean

    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userdetailsService);

        //no password encoder
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }

}