package com.example.ssiach2ex1.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter  {

    @Override
    protected  void configure(AuthenticationManagerBuilder auth)throws Exception {
        var userDetailService = new InMemoryUserDetailsManager();
        var user = User.withUsername("chaker").password("1234").authorities("read").build();
        userDetailService.createUser(user);

        auth.userDetailsService(userDetailService).passwordEncoder(NoOpPasswordEncoder.getInstance());


    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests().anyRequest().permitAll();
    }


        }

