package com.satyam.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/*
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
 */

@Configuration
@EnableWebSecurity
public class SpringConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

            /*
             | CSRF Configuration
             |
             | CSRF is mainly needed for browser-based session authentication.
             | Since we are using stateless APIs, disabling it is common.
             |
             */
            .csrf(csrf -> csrf.disable())

            /*
             | Authorization Rules
             |
             | Every incoming request must be authenticated.
             |
             */
            .authorizeHttpRequests(auth ->
                    auth.anyRequest().authenticated()
            )

            /*
             |--------------------------------------------------------------------------
             | Authentication Methods
             |--------------------------------------------------------------------------
             */

            // Default Spring Security login form
            .formLogin(Customizer.withDefaults())

            // HTTP Basic Authentication
            .httpBasic(Customizer.withDefaults())

            /*
             | Session Management
             |
             | STATELESS means:
             | - Spring Security will NOT create sessions
             | - Every request must carry authentication credentials
             | - Commonly used in REST APIs with JWT
             |
             */
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        return http.build();
    }

    //same thing without lambdaa
    public SecurityFilterChain withoutLambda(HttpSecurity http){

        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> configure) {
                configure.disable();
            }
        };

        http.csrf(custCsrf);


        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
            @Override
            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
                      registry.anyRequest().authenticated();
            }
        };

        http.authorizeHttpRequests(custHttp);


        return http.build();

    }
}