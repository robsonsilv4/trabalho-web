package com.robson.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// private final AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private DataSource dataSource;

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.csrf().disable().authorizeRequests().antMatchers("/", "/inicio",
	// "/registro", "/error").permitAll().anyRequest()
	// .authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll().and().logout()
	// .permitAll();
	// }

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery("SELECT nome, senha, ativo FROM usuario WHERE nome=?")
				.authoritiesByUsernameQuery("SELECT u.nome, p.papel" + "FROM usuario u "
						+ "INNER JOIN usuario_papel up " + "ON(u.usuario_id=ur.usuario_id) " + "INNER JOIN papel p "
						+ "ON(ur.papel_id=p.papel_id) " + "WHERE u.nome=?")
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder());

		// auth.jdbcAuthentication().dataSource(dataSource)
		// .usersByUsernameQuery("SELECT nome, senha, ativo FROM usuario WHERE nome=?")
		// .authoritiesByUsernameQuery("SELECT senha, papel FROM usuario_papel WHERE
		// nome=?");
	}
	
//	@Autowired
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/", "/incio").permitAll().antMatchers("/usuarios").hasRole("ADMIN")
//				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
//				.permitAll();
//		http.exceptionHandling().accessDeniedPage("/403");
//	}
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .and()
            .formLogin()
                .failureUrl("/login?error")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/403");
	}

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

// @Autowired
// private UserDetailsServiceImp userDetailsServiceImp;
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
//
// http.csrf().disable().authorizeRequests()
// /* .antMatchers(HttpMethod.POST,"/produtos/adicionar").hasRole("ADMIN") */
// .antMatchers("/produtos/listar").permitAll().antMatchers("/cliente/formulario").permitAll()
// .antMatchers("/produtos//detalhes/{id}").permitAll()
// /*
// * .antMatchers(HttpMethod.POST,"/usuarios/adicionar").hasRole("USER")
// */ .antMatchers(/* HttpMethod.GET,
// */"/usuarios/listar").hasRole("ADMIN").anyRequest().authenticated()
// .and().formLogin().defaultSuccessUrl("/produtos/listar").loginPage("/login").permitAll()
// // .and().logout().logoutRequestMatcher(new
// AntPathRequestMatcher("/logout"));
//
// .and().logout().logoutSuccessUrl("/cliente/logar?logout").permitAll();
// }
//
// @Override
// protected void configure(AuthenticationManagerBuilder auth) throws Exception
// {
// auth.userDetailsService(userDetailsServiceImp).passwordEncoder(new
// BCryptPasswordEncoder());
//
// }
//
// @Override
// public void configure(WebSecurity web) throws Exception {
// web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/images/**");
// }
// }
