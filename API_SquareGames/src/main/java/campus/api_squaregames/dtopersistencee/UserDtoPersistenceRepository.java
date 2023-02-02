package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDtoPersistenceRepository extends CrudRepository<UserDtoPersistence, Integer> {
    
    List<UserDtoPersistence> findAllByUsernameExists = null;

    List<UserDtoPersistence> findByUsername(String username);

}
