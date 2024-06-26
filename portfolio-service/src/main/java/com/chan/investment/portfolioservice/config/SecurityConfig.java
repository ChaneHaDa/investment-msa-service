package com.chan.investment.portfolioservice.config;

import com.chan.investment.portfolioservice.filter.JwtTokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api-docs", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/portfolioItem/**").hasRole("USER")
                .requestMatchers("/portfolio/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
        );

        http.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class);
        http.csrf().disable();

        http.sessionManagement((sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        return http.build();
    }

}
