package campus.api_squaregames.dtoweb;

import java.util.List;

public class UserDtoWebAuthentification {

    private List<String> authorities;

    private String password;

    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

