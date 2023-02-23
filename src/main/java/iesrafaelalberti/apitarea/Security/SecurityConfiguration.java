package iesrafaelalberti.apitarea.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class SecurityConfiguration {

    @Bean
    public WebSecurityCustomizer WebSecurityCustomizer(){
        return (web) -> web.ignoring().anyRequest();
    }
}
