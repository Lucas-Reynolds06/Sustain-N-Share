package eco.sustainnshare.webapp.config.security;

import eco.sustainnshare.webapp.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.List;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService usersService;
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        var paths = List.of("/",
                "/about-us",
                "/how-it-works",
                "/impact",
                "/blog/**",
                "/blog/",
                "/contact-us",
                "/community-stories",
                "/faqs",
                "/sign-up",
                "/log-out",
                "/sign-in",
                "/**jpg",
                "/**JPG",
                "/**png",
                "/images/**",
                "/item-images/**",
                "/style.css",
                "/sharing-page",
                "/search-items",
                "/avitars/**",
                "/style.css");
        http.csrf(csrf->
            csrf.ignoringRequestMatchers(toH2Console())
                    .disable()
        )
        .authorizeHttpRequests(authConfig -> {
            paths.forEach(path -> authConfig.requestMatchers(new MvcRequestMatcher(new HandlerMappingIntrospector(), path))
                            .permitAll());
            authConfig.requestMatchers(toH2Console()).permitAll();
            authConfig.anyRequest().authenticated();
        })
        .formLogin(login -> {
            login.loginPage("/sign-in");
            login.defaultSuccessUrl("/profile", true);
            //ToDo add a login error page
        }).logout(
                logout -> {
                    logout.logoutRequestMatcher(new MvcRequestMatcher(new HandlerMappingIntrospector(), "/log-out"));
                    logout.logoutSuccessUrl("/");
                    logout.deleteCookies("JSESSIONID");
                    logout.invalidateHttpSession(true);
                }
        )
        .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }

    @Bean
    ApplicationListener<AuthenticationSuccessEvent> successEvent(){
        return event -> {
            System.out.println("Success Login " + event.getAuthentication().getClass().getSimpleName() + " - " + event.getAuthentication().getName());
        };
    }

    @Bean
    ApplicationListener<AuthenticationFailureBadCredentialsEvent> failureEvent(){
        return event -> {
            System.err.println("Bad Credentials Login " + event.getAuthentication().getClass().getSimpleName() + " - " + event.getAuthentication().getName());
        };
    }
}
