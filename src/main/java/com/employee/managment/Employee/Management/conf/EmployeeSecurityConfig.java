package com.employee.managment.Employee.Management.conf;


import com.employee.managment.Employee.Management.util.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfig {


    private final JwtRequestFilter jwtRequestFilter;

    public EmployeeSecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        try {
            http
                    .authorizeHttpRequests(authorize -> authorize
                            .requestMatchers("/employee/**")
                            .authenticated()
                            .anyRequest().permitAll()
                    )
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session -> session
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .csrf(csrf -> csrf.disable());
            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
            return http.build();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Exception From Http Request Matcher.This API Need's Authentication");
        }

    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        try {
            return authenticationConfiguration.getAuthenticationManager();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Exception From Authentication Manager!");
        }
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() throws Exception {
        try {
            return new BCryptPasswordEncoder();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Exception From Password Encoder!");
        }
    }

}

