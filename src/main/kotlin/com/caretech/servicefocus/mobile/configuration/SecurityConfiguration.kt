package com.caretech.servicefocus.mobile.configuration

import com.caretech.servicefocus.mobile.core.security.Argon2PasswordEncoder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.annotation.Resource
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Resource(name = "userService")
    private lateinit var userDetailsService: UserDetailsService

    @Autowired
    lateinit var dataSource: DataSource

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return Argon2PasswordEncoder()
    }

    @Autowired
    @Throws(Exception::class)
    fun globalUserDetails(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
    }



    override fun configure(http: HttpSecurity?) {
        if (http != null) {

            http.authorizeRequests()
                    .antMatchers("/login","/oauth/**")
                    .permitAll()
                    .and()

                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login?error=true")
                    .permitAll()
                    .and()

                    .logout()
                    .logoutSuccessUrl("/login?logout=true")
                    .invalidateHttpSession(true)
                    .permitAll()

                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                    .and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

            http
                    .requiresChannel()
                    .requestMatchers(RequestMatcher { httpServletRequest -> httpServletRequest.getHeader("X-Forwarded-Proto") != null })
                    .requiresSecure()
            http
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
            // http.authorizeRequests().antMatchers("/").permitAll()
        }
    }

    @Bean
    fun corsFilter(): FilterRegistrationBean<*> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.setOrder(0)
        return bean
    }
}