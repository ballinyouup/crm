package com.insurenebula.crm.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(Customizer -> Customizer.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        // .requestMatchers("/api/**")
                        // .authenticated()
                        
                        .requestMatchers("/**")
                        .permitAll()
                        );
        return http.build();
    }
}
