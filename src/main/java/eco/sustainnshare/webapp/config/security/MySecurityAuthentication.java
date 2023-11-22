package eco.sustainnshare.webapp.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class MySecurityAuthentication implements Authentication {
    private static final long serialVersionUID = 1L;

    private final boolean isAuthenticated;
    private final String name;
    private final String password;
    private final MySecurityUser mySecurityUser;
    private final Collection<GrantedAuthority> authorities;

    public MySecurityAuthentication(String name, String password, MySecurityUser mySecurityUser, Collection<GrantedAuthority> authorities) {
        this.isAuthenticated = password == null;
        this.name = name;
        this.password = password;
        this.mySecurityUser = mySecurityUser;
        this.authorities = authorities;
    }

    public static MySecurityAuthentication unauthenticated(String name, String password){
        return new MySecurityAuthentication(name, password,null, Collections.emptyList());
    }

    public static MySecurityAuthentication authenticated(MySecurityUser myUser){
        return new MySecurityAuthentication(myUser.getUsername(),null, myUser,myUser.getAuthorities());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return mySecurityUser;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalArgumentException("unimplemented");
    }

    @Override
    public String getName() {
        return name;
    }
}
