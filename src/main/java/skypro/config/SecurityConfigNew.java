package skypro.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Chip").password("abc").roles("Employee"))
                .withUser(userBuilder.username("Dale").password("cba").roles("IT"))
                .withUser(userBuilder.username("MontereyJack").password("123").roles("IT", "Security"))
                .withUser(userBuilder.username("GadgetHackwrench").password("321").roles("IT", "Security", "Director"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests()
                 .antMatchers("/").hasAnyRole("Employee", "IT", "Security", "Director")
                 .antMatchers("/it_room").hasAnyRole("IT", "Security", "Director")
                 .antMatchers("/security_room").hasAnyRole("Security", "Director")
                 .antMatchers("/director_room").hasAnyRole("Director")
                 .and().formLogin().permitAll();
    }
}
