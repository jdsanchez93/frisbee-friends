package com.jd_sanchez.frisbeefriendsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

@SpringBootApplication
@EnableWebSecurity
public class FrisbeeFriendsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrisbeeFriendsServiceApplication.class, args);
	}

	// @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	// Exception {

	// // http
	// // .authorizeHttpRequests((authz) -> authz
	// // .requestMatchers("/", "/error").permitAll()
	// // .anyRequest().authenticated())
	// // .exceptionHandling(e -> e
	// // .authenticationEntryPoint(new
	// HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
	// // .oauth2Login();

	// http
	// .authorizeHttpRequests(authorize -> authorize
	// .anyRequest().authenticated())
	// .oauth2Login(withDefaults());

	// return http.build();

	// }

	// // http://localhost:8080/api/login/oauth2/code/github
	// @Bean
	// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	// http
	// .oauth2Login(oauth2 -> oauth2
	// // .loginPage("/login/oauth2")
	// .authorizationEndpoint(authorization -> authorization
	// .baseUri("/api/login/oauth2/authorization")));
	// return http.build();
	// }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// by default uses a Bean by the name of corsConfigurationSource
				.cors(c -> c.disable())
				.authorizeHttpRequests(authorize -> authorize

						.requestMatchers("/api/**").authenticated()
						.requestMatchers("/**").permitAll()

				)
				// .httpBasic(null)
				.oauth2Login(withDefaults());

		// .oauth2

		// .oauth2Login(oauth2 -> oauth2
		// .loginPage("/login/oauth2")
		// .authorizationEndpoint(authorization -> authorization
		// .baseUri("/api/login/oauth2/authorization"))
		// .tokenEndpoint());

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
