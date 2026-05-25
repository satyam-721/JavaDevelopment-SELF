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





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http


            .csrf(csrf -> csrf.disable())


            .authorizeHttpRequests(auth ->
                    auth.requestMatchers("register")
                            .permitAll()
                            .anyRequest().authenticated()
            )


            // Default Spring Security login form
            .formLogin(Customizer.withDefaults())

            // HTTP Basic Authentication
            .httpBasic(Customizer.withDefaults());


        return http.build();
    }





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