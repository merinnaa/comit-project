//package org.comit.project.config;
//
//import org.comit.project.security.CustomPasswordEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests((requests) -> requests
//			    .antMatchers("/.index", "/.admin","/").permitAll()
//				.anyRequest().authenticated()
//			)
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
//			.logout((logout) -> logout.permitAll())
//			.csrf().disable();
//		return http.build();
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new CustomPasswordEncoder();
//	}
//
//	
////	@Bean
////	public EmployeeDetailService userDetailsService() {
////		EmployeeDetail user =
////			 User.withDefaultPasswordEncoder()
////				.username("user")
////				.password("password")
////				.roles("ROLE")
////				.build();
////
////		return new InMemoryUserDetailsManager(user);
////	}
//}
package org.comit.project.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
					.antMatchers("/js/**","/img/**","/","/create","/employee","/index","/mycartgetid/{id}","/payroll","/login","/timesheet","/update").permitAll()	
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			.csrf().disable();
		return http.build();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("ADMIN")
				.password("1234")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	
}}