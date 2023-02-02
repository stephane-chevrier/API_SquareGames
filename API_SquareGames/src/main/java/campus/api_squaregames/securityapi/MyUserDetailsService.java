package campus.api_squaregames.securityapi;

import campus.api_squaregames.dtopersistencee.UserDtoPersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDtoPersistenceRepository userDtoPersistenceRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        return userDtoPersistenceRepository.findByUsername(username);
    }


}