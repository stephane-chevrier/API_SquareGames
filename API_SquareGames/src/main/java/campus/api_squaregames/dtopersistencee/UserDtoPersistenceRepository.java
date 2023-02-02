package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;

public interface UserDtoPersistenceRepository extends CrudRepository<UserDtoPersistence, Integer> {

    UserDtoPersistence findByUsername(String username);

}
