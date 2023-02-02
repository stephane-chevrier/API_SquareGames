package campus.api_squaregames.dtoweb;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class UserDtoWeb {

    private List<String> authorities;

    private String password;

    private String username;

//    private boolean accountNonExpired = true;
//
//    private boolean accountNonLocked = true;
//
//    private boolean credentialsNonExpired = true;
//
//    private boolean enabled = true;

    public UserDtoWeb(UserDetails userDetails) {
        this.password = userDetails.getPassword();
        this.username = userDetails.getUsername();
    }

    public UserDtoWeb() {
    }

    public List<String> getAuthorities() {
        return null;
    }

//    public void setAuthorities(List<String> authorities) {
//        this.authorities = authorities;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public boolean isAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }
//
//    public boolean isAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }
//
//    public boolean isCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
}
