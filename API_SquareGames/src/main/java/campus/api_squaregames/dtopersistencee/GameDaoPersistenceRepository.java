package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;

/**
 * The interface Game dao persistence repository.
 */
public interface GameDaoPersistenceRepository extends CrudRepository<GameDtoPersistence, Long> {

}
