package com.example.first.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails headOfHr = User.withUsername("head_hr").
                password(passwordEncoder().encode("abc")).roles("HR").build();
        return new InMemoryUserDetailsManager(headOfHr);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF disable කරන නව DSL
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/employees/update/**").hasRole("HR") // "HR" role එකට පමණක් අවසර
                        .anyRequest().authenticated() // වෙන requests වලට authentication
                )
                .httpBasic(httpBasic -> {
                }); // Basic Authentication භාවිතා කිරීම
        return http.build(); // SecurityFilterChain එක return කරන එක
    }
}
