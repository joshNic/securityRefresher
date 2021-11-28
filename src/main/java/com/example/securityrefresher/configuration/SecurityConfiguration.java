package com.example.securityrefresher.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        //set configs on the auth object
//        auth.inMemoryAuthentication()
//                .withUser("test")
//                .password("test")
//                .roles("TEST")
//                .and()
//                .withUser("test2")
//                .password("test2")
//                .roles("ADMIN");

//        auth.jdbcAuthentication().dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser(
//                        User.withUsername("test")
//                                .password("test")
//                                .roles("TEST")
//                )
//                .withUser(
//                        User.withUsername("test2")
//                                .password("test2")
//                                .roles("ADMIN")
//                );
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,enabled from users where username = ?")
//                .authoritiesByUsernameQuery("select username,authority from authorities where username=?");

        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("TEST","ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }

}
