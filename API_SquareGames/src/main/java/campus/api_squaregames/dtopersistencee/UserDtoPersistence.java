package campus.api_squaregames.dtopersistencee;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class UserDtoPersistence implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ElementCollection
    private List<String> authorities;

    private String password;

    private String username;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

    public UserDtoPersistence() {
    }

    public UserDtoPersistence(String authorities, String password, String username, boolean accountNonExpired,
                              boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        addAuthorities(authorities);
        this.password = password;
        this.username = username;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream().map(s -> (GrantedAuthority) () -> s).collect(Collectors.toList());
    }

    public void addAuthorities(String authorities) {
        this.authorities.add(authorities);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
