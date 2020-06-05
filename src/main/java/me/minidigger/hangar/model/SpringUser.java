package me.minidigger.hangar.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import me.minidigger.hangar.config.SecurityConfig;

public class SpringUser implements UserDetails {

    private transient User user;

    public SpringUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return SecurityConfig.LOGGED_IN_AUTHORITIES;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static class AnonymousUser extends SpringUser {

        public static AnonymousUser INSTANCE = new AnonymousUser();

        private AnonymousUser() {
            super(null);
        }

        @Override
        public String getUsername() {
            return "Anonymous";
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return SecurityConfig.ANONYMOUS_AUTHORITIES;
        }
    }
}
