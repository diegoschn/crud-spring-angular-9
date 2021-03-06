package br.com.crud.config;

import br.com.crud.service.config.UsuarioLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioLoadService usuarioService;

    //AuthenticationManagerBuilder-> Serve para construir um AuthenticationManager, ou seja
    //essa classe vai gerenciar a autenticação na aplicação
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(usuarioService)
            .passwordEncoder(passwordEncoder());
    }

    //Essa classe AuthenticationManager quem vai gerenciar a autenticação na aplicação
    @Bean
    public AuthenticationManager  authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    //Método que configura a parte web
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

            .csrf().disable()
              .cors()
         .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
