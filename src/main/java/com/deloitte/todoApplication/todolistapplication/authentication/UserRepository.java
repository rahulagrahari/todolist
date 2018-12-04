package com.deloitte.todoApplication.todolistapplication.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);

    @EnableWebSecurity
    @Configuration
    class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private CustomUserDetailService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(getPasswordEncoder());
        }


    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //        auth.inMemoryAuthentication()
    //
    //                .withUser("user").password("user").roles("USER").and()
    //                .withUser("admin").password("admin").roles("ADMIN");
    //    }

    //    @Override
    //    protected void configure(HttpSecurity httpSecurity) throws Exception {
    //
    //        httpSecurity
    //                .authorizeRequests()
    ////                .anyRequest()
    //                .antMatchers("/login")
    //                .permitAll()
    //                .anyRequest()
    //                .fullyAuthenticated()
    //                .and()
    //                .httpBasic();
    //        httpSecurity.csrf().disable();
    //
    //    }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers("**/api/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                    .formLogin().permitAll();
        }

        private PasswordEncoder getPasswordEncoder() {
            return new PasswordEncoder() {
                @Override
                public String encode(CharSequence charSequence) {
                    return charSequence.toString();
                }

                @Override
                public boolean matches(CharSequence charSequence, String s) {
                    return true;
                }
            };
        }


    }
}
