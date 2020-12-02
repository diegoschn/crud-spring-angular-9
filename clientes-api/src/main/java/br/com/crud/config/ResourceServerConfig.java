package br.com.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    //Esse método é responsável por definir as regras de navegação
    //autorização de urls, cors e entre outros, configuração das resources da API
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/usuarios").permitAll()
                .antMatchers("/api/clientes/**").authenticated()
                .anyRequest().denyAll();
    }
}
