package me.minidigger.hangar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;

import me.minidigger.hangar.security.AnonymousAuthenticationProvider;
import me.minidigger.hangar.security.TokenAuthenticationFilter;
import me.minidigger.hangar.security.TokenAuthenticationProvider;
import me.minidigger.hangar.security.NoRedirectStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final GrantedAuthority LOGGED_IN = new SimpleGrantedAuthority("ROLE_LOGGED_IN");
    public static final GrantedAuthority ANONYMOUS = new SimpleGrantedAuthority("ROLE_ANONYMOUS");
    public static final List<GrantedAuthority> LOGGED_IN_AUTHORITIES = List.of(LOGGED_IN);
    public static final List<GrantedAuthority> ANONYMOUS_AUTHORITIES = List.of(ANONYMOUS);

    private final TokenAuthenticationProvider provider;
    private final AnonymousAuthenticationProvider anonymousProvider;

    private final AntPathRequestMatcher api = new AntPathRequestMatcher("/api/**");

    @Autowired
    public SecurityConfig(TokenAuthenticationProvider provider, AnonymousAuthenticationProvider anonymousProvider) {
        this.provider = provider;
        this.anonymousProvider = anonymousProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // enable anon user
        http.
                anonymous();

        // stateless sessions
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // disable csrf protection since that fucks with shit?
        http
                .csrf()
                .disable();

        // disabled not needed auth stuff
        http
                .formLogin().disable()
                .httpBasic().disable()
                .logout().disable();

        // error page
        http
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), api);

        // setup filter
        http
                .authenticationProvider(anonymousProvider)
                .authenticationProvider(provider)
                .addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class);

        // require auth for api
        http
                .authorizeRequests()
                .antMatchers("/api/**")
                .permitAll();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(anonymousProvider);
        auth.authenticationProvider(provider);
    }

    @Bean
    TokenAuthenticationFilter restAuthenticationFilter() throws Exception {
        final TokenAuthenticationFilter filter = new TokenAuthenticationFilter(api);
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(successHandler());
        filter.setAuthenticationFailureHandler(failureHandler());
        return filter;
    }

    @Bean
    SimpleUrlAuthenticationSuccessHandler successHandler() {
        final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setRedirectStrategy(new NoRedirectStrategy());
        return successHandler;
    }

    @Bean
    SimpleUrlAuthenticationFailureHandler failureHandler() {
        final SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
        failureHandler.setRedirectStrategy(new NoRedirectStrategy());
        return failureHandler;
    }

    /**
     * Disable Spring boot automatic filter registration.
     */
    @Bean
    FilterRegistrationBean<TokenAuthenticationFilter> disableAutoRegistration(final TokenAuthenticationFilter filter) {
        final FilterRegistrationBean<TokenAuthenticationFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(HttpStatus.FORBIDDEN);
    }
}
