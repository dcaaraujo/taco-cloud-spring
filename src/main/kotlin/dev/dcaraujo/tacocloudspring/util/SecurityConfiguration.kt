package dev.dcaraujo.tacocloudspring.util

import org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher
import org.springframework.web.servlet.handler.HandlerMappingIntrospector

@Configuration
class SecurityConfiguration {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(encoder: PasswordEncoder): UserDetailsService {
        val users = listOf(
            User("john", encoder.encode("Password@1"), listOf(SimpleGrantedAuthority("ROLE_USER"))),
            User("buzz", encoder.encode("Password@1"), listOf(SimpleGrantedAuthority("ROLE_USER")))
        )
        return InMemoryUserDetailsManager(users)
    }

    @Bean
    fun filterChain(http: HttpSecurity, introspector: HandlerMappingIntrospector): SecurityFilterChain {
        val mvcMatcher = MvcRequestMatcher.Builder(introspector)
        http
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers(mvcMatcher.pattern("/design"), mvcMatcher.pattern("/order")).hasRole("USER")
                    .anyRequest().permitAll()
            }
            .formLogin {
                it.loginPage("/login").defaultSuccessUrl("/design", true)
            }
            .logout {
                it.logoutSuccessUrl("/")
            }
            .csrf {
                it.ignoringRequestMatchers(toH2Console())
            }
            .headers {
                it.frameOptions().sameOrigin()
            }
        return http.build()
    }
}
