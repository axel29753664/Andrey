package lv.javaguru.java2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/","/registration").permitAll()
                .antMatchers("/adminPage").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/",true)
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .csrf().disable();

//                .antMatchers("/userPage").hasRole("USER")
//                .antMatchers("/bets").hasRole("USER")
//                .and()
//                .formLogin().failureUrl("/").defaultSuccessUrl("/userPage", true);
//                .antMatchers("/userPage").access()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
//                .and().formLogin().failureUrl("/").defaultSuccessUrl("/userPage", true);

//                .anyRequest().authenticated() //all requests will checked
//                .and()
//                .formLogin().loginPage("/login").permitAll().usernameParameter("j_username")
//                .passwordParameter("j_password").loginProcessingUrl("/j_spring_security_check").failureUrl("/login.html?error=true")
//                .and()
//                .httpBasic()
//                .and()
//                .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .and()
//                .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/")
//                .and()
//                .rememberMe().key("myKey").tokenValiditySeconds(300)
//                .and()
//                .csrf().disable();
    }

}
