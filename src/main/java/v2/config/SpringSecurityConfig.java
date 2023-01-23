//package v2.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig {
//
//    public SpringSecurityConfig() {
//        super();
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
//        http
//                .formLogin()
//                .loginPage("/login.html")
//                .failureUrl("/login-error.html")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/index.html")
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/", "/index.html","/login.html","/css/**","/favicon.ico").permitAll()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasRole("USER")
//                .requestMatchers("/shared/**").hasAnyRole("USER","ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403.html");
//        return http.build();
//    }
//
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("jim").password("{noop}demo").roles("ADMIN").build(),
//                User.withUsername("bob").password("{noop}demo").roles("USER").build(),
//                User.withUsername("ted").password("{noop}demo").roles("USER","ADMIN").build());
//    }
//
//
//}