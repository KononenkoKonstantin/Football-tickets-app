package football.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/games", "/stadiums",
                        "/game-sessions/available").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/shopping-carts/by-user/*",
                        "/orders").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/orders/complete",
                        "/shopping-carts/games-sessions").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/stadiums",
                        "/games", "/game-sessions").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/by-email").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/game-sessions").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/game-sessions").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
