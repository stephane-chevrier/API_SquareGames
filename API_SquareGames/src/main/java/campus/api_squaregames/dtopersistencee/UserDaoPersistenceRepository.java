package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;

/**
 * The interface User dao persistence repository.
 */
public interface UserDaoPersistenceRepository extends CrudRepository<UserDtoPersistence, Integer> {

    /**
     * Find by username user dto persistence.
     * declaration de la method permettant de renvoyer l'objet UserDetails correspondant à un nom de username
     * @param username the username
     * @return the user dto persistence
     */
    UserDtoPersistence findByUsername(String username);

}
