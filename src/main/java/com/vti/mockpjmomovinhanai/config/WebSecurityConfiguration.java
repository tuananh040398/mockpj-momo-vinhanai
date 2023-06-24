package com.vti.mockpjmomovinhanai.config;

import com.vti.mockpjmomovinhanai.config.jwt.JWTRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Kết hợp với @Bean để tạo thành 1 bean trong spring IOC
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //Để có thể phân quyền tại controller
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                // Config API không cần xác thực
                .antMatchers("/api/v1/product/get-all-productdto", "/api/v1/account/create"
                        ,"/api/v1/auth/login", "/api/v1/product/get-by/**", "/api/v1/product/search"
                        ,"/api/v1/organization/get-by/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/product/delete-by/**"
                        ,"api/v1/organization/get-all").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated() // Những đường dẫn còn lại cần dược xác thực
                .and().httpBasic() // Kích hoạt cấu hình http basic trong Spring Security
                .and().cors().and().csrf().disable(); // Tắt tính năng Cross-site Request Forgery (CSRF) trong spring Security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-ui/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/v3/api-docs/**");
    }
}
