package campus.api_squaregames.service;

import campus.api_squaregames.dtopersistencee.UserDaoPersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * The type My user details service.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    // initialisation de l'objet UserDaoPersistenceRepository
    @Autowired
    private UserDaoPersistenceRepository userDaoPersistenceRepository;

    // method permettant de renvoyer l'objet UserDetails correspondant à un nom de username
    @Override
    public UserDetails loadUserByUsername(final String username) {
        return userDaoPersistenceRepository.findByUsername(username);
    }


}