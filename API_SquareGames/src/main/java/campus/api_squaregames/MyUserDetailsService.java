package campus.api_squaregames;

import campus.api_squaregames.dtopersistencee.UserDtoPersistence;
import campus.api_squaregames.dtopersistencee.UserDtoPersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDtoPersistenceRepository userDtoPersistenceRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {

        UserDetails userDetails = null;

        if (userDtoPersistenceRepository.findAllByUsernameExists.contains(username)) {
            List<UserDtoPersistence> userDtoPersistence = userDtoPersistenceRepository.findByUsername(username);
            userDetails = (UserDetails) userDtoPersistence;
        }
        return userDetails;
    }


}