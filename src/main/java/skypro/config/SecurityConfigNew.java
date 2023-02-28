package skypro.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    public SecurityConfigNew(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);

//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("Chip").password("abc").roles("Employee"))
//                .withUser(userBuilder.username("Dale").password("cba").roles("IT"))
//                .withUser(userBuilder.username("MontereyJack").password("xyz").roles("IT", "Security"))
//                .withUser(userBuspring.username("GadgetHackwrench").password("zxy").roles("IT", "Security", "Director"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests()
                 .antMatchers("/").hasAnyRole("EMPLOYEE", "IT", "SECURITY", "DIRECTOR")
            //     .antMatchers("/employee_room").hasAnyRole("Employee", "IT", "Security", "Director")
                 .antMatchers("/it_room").hasAnyRole("IT", "SECURITY", "DIRECTOR")
                 .antMatchers("/security_room").hasAnyRole("SECURITY", "DIRECTOR")
                 .antMatchers("/director_room").hasAnyRole("DIRECTOR")
                 .and().formLogin().permitAll();
    }
}
