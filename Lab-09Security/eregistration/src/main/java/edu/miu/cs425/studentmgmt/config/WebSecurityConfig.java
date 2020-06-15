package edu.miu.cs425.studentmgmt.config;

import edu.miu.cs425.studentmgmt.service.EregistrarUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,proxyTargetClass = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    private UserDetailsService userDetailsService;


    public WebSecurityConfig(EregistrarUserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/static/**", "/images/**", "/css/**", "mystudentmgmtwebapp/public/**").permitAll()
                .antMatchers("/", "/mystudentmgmtwebapp").permitAll()
                .antMatchers("/mystudentmgmtwebapp/secured/services/admin/**").hasRole("ADMIN")
                .antMatchers("/mystudentmgmtwebapp/secured/services/student/**").hasRole("student")
                .antMatchers("/mystudentmgmtwebapp/secured/services/libmember/**").hasRole("LIBMEMBER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/mystudentmgmtwebapp/public/login")
                .defaultSuccessUrl("/mystudentmgmtwebapp/secured/home")
                .failureUrl("/mystudentmgmtwebapp/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/mystudentmgmtwebapp/public/logout"))
                .logoutSuccessUrl("/mystudentmgmtwebapp/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }

}
