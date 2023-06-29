package com.example.lms.config;

import com.example.lms.service.MyUserDetailsService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    LogoutSuccessHandler myLogoutSuccessHandler;

    @Resource
    MyUserDetailsService myUserDetailsService;

    @Resource
    MyRBACService myRBACService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                        //.defaultSuccessUrl("/", true)
                )
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/backend/**","/backend/courses").hasRole("admin")
                        .requestMatchers("/", "/login", "/build/**", "/video","/video-show", "/invalidSession", "/logout", "/vendor/**","/city/**", "/courses/**","/users/**","/seach","/pay","/pay/**","/courseDetail","/coursesDelete/**").permitAll()
//                        .requestMatchers("/backend/**").hasAnyRole("admin")
                                .anyRequest().permitAll()
//                        .anyRequest().access((authentication, context) ->
//                                new AuthorizationDecision(myRBACService.hasPermission(context.getRequest(), authentication.get())))
                )

                .sessionManagement(sm -> sm
                        //.invalidSessionUrl("/invalidSession")
                        //.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        //.sessionFixation().migrateSession()
                        //.sessionFixation().changeSessionId()
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(false)
                        .expiredSessionStrategy(new CustomExpiredSessionStrategy())
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        //.logoutSuccessUrl("/")
                        .logoutSuccessHandler(myLogoutSuccessHandler)
                        .permitAll()
                )
                .rememberMe(rm -> rm
                        .rememberMeParameter("remember-me")
                )
        ;
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/img/**", "/webjars/**");
    }
}
