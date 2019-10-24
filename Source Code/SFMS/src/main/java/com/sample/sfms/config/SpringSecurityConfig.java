package com.sample.sfms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.privileges-query}")
    private String privilegesQuery;

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.debug(true)
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/vendor/**");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().usersByUsernameQuery(usersQuery)
//                .authoritiesByUsernameQuery(privilegesQuery)
//                .dataSource(dataSource)
//                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
<<<<<<< Updated upstream
        http.csrf().disable();
//                .authorizeRequests()
//                .antMatchers("/", "/login").permitAll()
//                .antMatchers("/roles/**").hasAuthority("EDIT_PERMISSION")
//                .antMatchers("/users/**").access("hasAuthority('EDIT_PERMISSION') or hasAuthority('EDIT_FEEDBACK')")
//                .antMatchers("/feedbacks/**").access("hasAuthority('EDIT_PERMISSION') or hasAuthority('EDIT_FEEDBACK')")
//                .mvcMatchers("/conduct-feedback/**").access("hasAuthority('CONDUCT_FEEDBACK')")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/home")
//                .and()
//                .rememberMe().rememberMeParameter("remember-me")
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/").and().exceptionHandling()
//                .accessDeniedPage("/access-denied");
=======
        http.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/", "/login").permitAll()
                .mvcMatchers("/roles/**").hasAuthority("EDIT_PERMISSION")
                .mvcMatchers("/users/**").access("hasAuthority('EDIT_USER')")
                .mvcMatchers("/feedbacks/**").access("hasAuthority('EDIT_PERMISSION') or hasAuthority('EDIT_FEEDBACK')")
                .mvcMatchers("/conduct-feedback/**").access("hasAuthority('CONDUCT_FEEDBACK')")
                .mvcMatchers("/reports/**").access("hasAuthority('SEE_ALL_REPORT') or hasAuthority('SEE_SELF_REPORT') or hasAuthority('SEE_DEPARTMENT_REPORT')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/skeleton")
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
>>>>>>> Stashed changes
    }
}