package ru.taf.sensorrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManager->sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//                .formLogin(AbstractHttpConfigurer::disable)
//                .securityMatcher("/**")
//                .authorizeHttpRequests(registry->registry
//                        .requestMatchers("/").permitAll()
//                );
        return http.build();
    }
}
