package campus.api_squaregames.dtopersistencee;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type User dto persistence.
 */
@Entity
public class UserDtoPersistence implements UserDetails {

    // creation des proprietes de l'objet
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    // @ElementCollection : permet d'enregistrer la collection annotée depuis la table principale
    // (fetch = FetchType.EAGER) : indique que la relation doit être chargée en même temps que l'entité qui la porte.
    @ElementCollection (fetch = FetchType.EAGER)
    private List<String> authorities;

    private String password;

    private String username;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

    /**
     * Instantiates a new User dto persistence.
     */
    public UserDtoPersistence() {
    }

    /**
     * Instantiates a new User dto persistence.
     *
     * @param username the username
     * @param password the password
     */
    public UserDtoPersistence(String username,String password) {
        this.username = username;
        this.password = password;
    }
    /**
     * Instantiates a new User dto persistence.
     *
     * @param username the username
     */
    public UserDtoPersistence(String username) {
        this.username = username;
    }

    /**
     * Instantiates a new User dto persistence.
     *
     * @param authorities           the authorities
     * @param password              the password
     * @param username              the username
     * @param accountNonExpired     the account non expired
     * @param accountNonLocked      the account non locked
     * @param credentialsNonExpired the credentials non expired
     * @param enabled               the enabled
     */
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

    /**
     * Add authorities.
     *
     * @param authorities the authorities
     */
    public void addAuthorities(String authorities) {
        this.authorities.add(authorities);
    }

    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
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
