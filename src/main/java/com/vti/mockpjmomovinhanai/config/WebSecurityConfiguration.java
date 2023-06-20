package com.vti.mockpjmomovinhanai.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration // Kết hợp với @Bean để tạo thành 1 bean trong spring IOC
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //Để có thể phân quyền tại controller
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/api/v1/product/get-all-productdto").permitAll() // Config API không cần xác thực
                .antMatchers("/api/v1/account/get-all").hasAnyAuthority("ADMIN")
                .anyRequest().permitAll() // Những đường dẫn còn lại cần dược xác thực
                .and().httpBasic() // Kích hoạt cấu hình http basic trong Spring Security
                .and().cors().and().csrf().disable(); // Tắt tính năng Cross-site Request Forgery (CSRF) trong spring Security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-ui/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/v3/api-docs/**");
    }
}
